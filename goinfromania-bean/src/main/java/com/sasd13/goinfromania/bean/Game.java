package com.sasd13.goinfromania.bean;

import java.sql.Timestamp;
import java.util.Observable;

public class Game extends Observable {

	private long id;
	private EnumState state;
	private EnumLevel level;
	private Arena arena;
	private int score;
	private EnumResult result;
	private Timestamp dateCreation, dateLastUpdate;

	public Game() {
		state = EnumState.NONE;
		arena = new Arena(this);
		result = EnumResult.NONE;
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

	public Arena getArena() {
		return arena;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;

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

	public static Game clone(Game game) {
		// TODO : clone
		return null;
	}
}
