package game.element.character;

import game.element.power.Power;

public abstract class Enemy extends Character {

	private Power power;
	private int scorePoint;
	
	public Enemy() {
		super();
		
		setPowerful(true);
		
		this.power = null;
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
