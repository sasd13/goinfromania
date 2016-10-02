package com.sasd13.goinfromania.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.sasd13.goinfromania.bean.character.Pig;

public class Game extends Observable {

	private long id;
	private EnumState state;
	private EnumLevel level;
	private EnumResult result;
	private int score;
	private Timestamp dateCreation, dateLastUpdate;
	private List<IElement> elements;
	private Pig pig;

	public Game() {
		state = EnumState.NONE;
		result = EnumResult.NONE;
		elements = new ArrayList<IElement>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;

		setChanged();
		notifyObservers();
	}

	public EnumState getState() {
		return state;
	}

	public void setState(EnumState state) {
		this.state = state;

		setChanged();
		notifyObservers();
	}

	public EnumLevel getLevel() {
		return level;
	}

	public void setLevel(EnumLevel level) {
		this.level = level;

		setChanged();
		notifyObservers();
	}

	public EnumResult getResult() {
		return result;
	}

	public void setResult(EnumResult result) {
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

		if (element instanceof Pig) {
			pig = (Pig) element;
		}

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

	public static Game clone(Game game) {
		// TODO : clone
		return null;
	}
}
