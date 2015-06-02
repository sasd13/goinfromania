package main.java.game.element.character;

import main.java.game.element.power.Power;

public abstract class Enemy extends Character {
	
	private Power power;
	private int scorePoint;
	
	public Enemy() {
		super();
		
		setPowerful(true);
		
		this.power = null;
		this.scorePoint = 0;
	}
	
	public Power getPower() {
		return this.power;
	}
	
	public void setPower(Power power) {
		this.power = power;
		
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
