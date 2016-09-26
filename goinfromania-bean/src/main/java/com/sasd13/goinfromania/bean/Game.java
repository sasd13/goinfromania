package com.sasd13.goinfromania.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.sasd13.goinfromania.bean.character.Pig;

public class Game extends Observable {

	private long id;
	private State state;
	private Level level;
	private Result result;
	private int score;
	private Timestamp dateCreation, dateLastUpdate;
	private List<IElement> elements;
	private Pig pig;

	public Game() {
		elements = new ArrayList<IElement>();
		pig = new Pig();
		
		elements.add(pig);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		
		setChanged();
		notifyObservers();
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
	
	public List<IElement> getElements() {
		return elements;
	}

	public void addElement(IElement element) {
		elements.add(element);

		setChanged();
		notifyObservers();
	}

	public void removeElement(IElement element) {
		elements.remove(element);

		setChanged();
		notifyObservers();
	}
	
	public Pig getPig() {
		return pig;
	}
}
