package com.sasd13.goinfromania.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="games")
public class Game extends Observable {
	
	@Column(name="game_id")
	@Id @GeneratedValue
	private long id;
	
	@Column(name="game_state")
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Column(name="game_level")
	@Enumerated(EnumType.STRING)
	private Level level;
	
	@Column(name="game_result")
	@Enumerated(EnumType.STRING)
	private Result result;
	
	@Column(name="game_score")
	private int score;
	
	@Column(name="game_datecreation")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp dateCreation;
	
	@Column(name="game_datelastupdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp dateLastUpdate;
	
	@OneToMany(mappedBy="games", cascade=CascadeType.PERSIST)
	private List<IElement> elements;
	
	public Game() {
		this.elements = new ArrayList<IElement>();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
}
