package game.round;

import java.util.Observable;

public class RoundStats extends Observable {
	
	private int totalScore;
	private int totalCountEatenCakes;
	private int totalCountNutritionistKilled;
	private int totalCountVirusKilled;
	
	public RoundStats() {
		super();
		
		this.totalScore = 0;
		this.totalCountEatenCakes = 0;
		this.totalCountNutritionistKilled = 0;
		this.totalCountVirusKilled = 0;
	}
	
	public int getTotalScore() {
		return this.totalScore;
	}
	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalCountEatenCakes() {
		return this.totalCountEatenCakes;
	}
	
	public void setTotalCountEatenCakes(int totalCountEatenCakes) {
		this.totalCountEatenCakes = totalCountEatenCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalCountNutritionistKilled() {
		return this.totalCountNutritionistKilled;
	}
	
	public void setTotalCountNutritionistKilled(int totalCountNutritionistKilled) {
		this.totalCountNutritionistKilled = totalCountNutritionistKilled;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalCountVirusKilled() {
		return this.totalCountVirusKilled;
	}
	
	public void setTotalCountVirusKilled(int totalCountVirusKilled) {
		this.totalCountVirusKilled = totalCountVirusKilled;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalFoodEated() {
		return this.totalCountEatenCakes;
	}
	
	public int getTotalEnemyKilled() {
		return this.totalCountNutritionistKilled + this.totalCountVirusKilled;
	}
}
