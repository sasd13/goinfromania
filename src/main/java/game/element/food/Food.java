package main.java.game.element.food;

import main.java.game.element.Element;

public abstract class Food extends Element {

	private boolean eated;
	private int effectValue;
	private int scorePoint;
	
	protected Food() {
		super();
		
		setMovable(true);
		
		this.eated = false;
		this.effectValue = 0;
		this.scorePoint = 0;
	}
	
	public boolean isEated() {
		return this.eated;
	}
	
	public void setEated(boolean eated) {
		this.eated = eated;
		
		setChanged();
		notifyObservers();
	}
	
	public int getEffectValue() {
		return this.effectValue;
	}
	
	public void setEffectValue(int effectValue) {
		this.effectValue = effectValue;
		
		setChanged();
		notifyObservers();
	}
	
	public int getScorePoint() {
		return this.scorePoint;
	}
	
	public void setScorePoint(int scorePoint) {
		this.scorePoint = scorePoint;
		
		setChanged();
		notifyObservers();
	}
}
