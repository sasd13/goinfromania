package main.java.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import main.java.bean.character.pig.Pig;

public class Game extends Observable {
	
	public static final String NAME = "Goinfr'o'mania";

	private State state;
	private Level level;
	private Result result;
	private int score;
	private Timestamp dateCreation, dateLastUpdate;
	private List<IElement> elements;
	
	public Game() {
		this.elements = new ArrayList<IElement>();
		
		addElement(new Pig());
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
	
	public void addElement(IElement element) {
		this.elements.add(element);
		
		setChanged();
		notifyObservers();
	}
	
	public void removeElement(IElement element) {
		this.elements.remove(element);
		
		setChanged();
		notifyObservers();
	}
	
	public IElement[] getElements() {
		return this.elements.toArray(new IElement[this.elements.size()]);
	}
	
	public Pig getPig() {
		for (IElement element : this.elements) {
			if ("PIG".equalsIgnoreCase(element.getClass().getSimpleName())) {
				return (Pig) element;
			}
		}
		
		return null;
	}
}
