package game.round;

import game.element.Element;
import game.element.ListElement;
import game.element.character.Life;
import game.element.character.Pig;
import game.setting.Level;

import java.awt.Point;
import java.util.Observable;

public class Round extends Observable {

	public static final int TOTAL_CAKE_TO_EAT_LEVEL_EASY = 10;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_NORMAL = 20;
	public static final int TOTAL_CAKE_TO_EAT_LEVEL_HARD = 30;
	
	private static int numberRound = 0;
	private String id;
	private Level level;
	private Score score;
	private Pig pig;
	private ListElement listElement;
	private int numberEatenCakes;
	private boolean finished;
	
	public Round() {
		super();
		
		numberRound++;
		this.id = "id-round-"+numberRound;
		this.level = Level.EASY;
		this.score = new Score();
		this.pig = new Pig();
		this.listElement = new ListElement();
		this.numberEatenCakes = 0;
		this.finished = false;
	}
	
	public String getId() {
		return this.id;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
		
		setChanged();
		notifyObservers();
	}
	
	public Score getScore() {
		return this.score;
	}
	
	public void setScore(Score score) {
		this.score = score;
		
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
	
	public int getNumberEatenCakes() {
		return this.numberEatenCakes;
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
		
		setChanged();
		notifyObservers();
	}
	
	public void cakeEaten() {
		this.numberEatenCakes++;
		
		checkEatenCakes();
	}
	
	public void checkPigLife() {
		Life life = this.pig.getLife();
		
		if (life.getValue() == Life.LIFE_MIN) {
			this.pig.setAlive(false);
			setFinished(true);
		}
	}
	
	private void checkEatenCakes() {
		if ((this.level == Level.EASY && this.numberEatenCakes == Round.TOTAL_CAKE_TO_EAT_LEVEL_EASY) 
				|| (this.level == Level.NORMAL && this.numberEatenCakes == Round.TOTAL_CAKE_TO_EAT_LEVEL_NORMAL)
				|| this.level == Level.HARD && this.numberEatenCakes == Round.TOTAL_CAKE_TO_EAT_LEVEL_HARD) {
			setFinished(true);
		}
	}
	
	public void start() {
		setChanged();
		notifyObservers();
	}
	
	public void resume() {
		setChanged();
		notifyObservers();
	}
	
	public void pause() {
		setChanged();
		notifyObservers();
	}
	
	public RoundResult stop() {
		if (this.finished) {
			if (this.pig.isAlive()) {
				return RoundResult.WIN;
			} else {
				return RoundResult.LOOSE;
			}
		} else {
			return RoundResult.PROGRESS;
		}
	}
}
