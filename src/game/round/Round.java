package game.round;

import game.element.Element;
import game.element.ListElement;
import game.element.character.Pig;

import java.awt.Point;
import java.util.Observable;

public class Round extends Observable {

	public static final int TOTAL_CAKE_TO_EAT_LEVEL_EASY = 10;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_NORMAL = 20;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_HARD = 30;
	
	private static int countRound = 0;
	private String id;
	private int number;
	private Level level;
	private Result result;
	private Score cumulatedScore;
	private Pig pig;
	private ListElement listElement;
	private boolean finished;
	
	public Round(int number) {
		super();
		
		countRound++;
		this.id = "id-round-" + countRound;
		this.number = number;
		this.level = Level.EASY;
		this.cumulatedScore = new Score();
		this.pig = new Pig();
		this.listElement = new ListElement();
		this.finished = false;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
		
		setChanged();
		notifyObservers();
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		setChanged();
		notifyObservers();
	}
	
	public Result getResult() {
		return this.result;
	}
	
	public void setResult(Result result) {
		this.result = result;
		
		setChanged();
		notifyObservers();
	}
	
	public Score getCumulatedScore() {
		return this.cumulatedScore;
	}
	
	public void setCumulatedScore(Score cumulatedScore) {
		this.cumulatedScore = cumulatedScore;
		
		setChanged();
		notifyObservers();
	}
	
	public Pig getPig() {
		return this.pig;
	}
	
	public ListElement getListElement() {
		return this.listElement;
	}
	
	public boolean addElement(Element element) {
		boolean added = this.listElement.add(element);
		
		setChanged();
		notifyObservers();
		
		return added;
	}
	
	public boolean removeElement(Element element) {
		boolean removed = this.listElement.remove(element);
		
		setChanged();
		notifyObservers();
		
		return removed;
	}
	
	public Element getElement(String elementId) {
		Element element = null;
		
		for (int i=0; i<this.listElement.size(); i++) {
			element = this.listElement.get(i);
			if (element.getId().compareTo(elementId) == 0) {
				return element;
			}
		}
		
		return null;
	}
	
	public Element getElementAtPosition(Point position) {
		Element element = null;
		
		for (int i=0; i<this.listElement.size(); i++) {
			element = this.listElement.get(i);
			if (element.getPosition().equals(position)) {
				return element;
			}
		}
		
		return null;
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
		
		setChanged();
		notifyObservers();
	}
	
	public void cumulScore(Score score) {
		if (score != null) {
			this.cumulatedScore.setValue(this.cumulatedScore.getValue() + score.getValue());
		}
	}
}
