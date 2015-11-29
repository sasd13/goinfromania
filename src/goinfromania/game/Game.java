package goinfromania.game;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {
	
	public static final String NAME = "Goinfr'o'mania";

	private State state;
	private Level level;
	private Result result;
	private int score;
	private Timestamp dateCreation, dateLastUpdate;
	private Player player;
	private List<Element> elements;
	
	public Game() {
		this.elements = new ArrayList<Element>();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		
		setChanged();
		notifyObservers();
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		
		setChanged();
		notifyObservers();
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
		
		setChanged();
		notifyObservers();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		
		setChanged();
		notifyObservers();
	}

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
		
		setChanged();
		notifyObservers();
	}

	public Timestamp getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(Timestamp dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
		
		setChanged();
		notifyObservers();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		
		setChanged();
		notifyObservers();
	}
	
	public void addElement(Element element) {
		this.elements.add(element);
		
		setChanged();
		notifyObservers();
	}
	
	public void removeElement(Element element) {
		this.elements.remove(element);
		
		setChanged();
		notifyObservers();
	}
	
	public Element[] getElements() {
		return this.elements.toArray(new Element[this.elements.size()]);
	}
}
