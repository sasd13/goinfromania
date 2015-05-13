package game.round;

import java.util.Observable;

public class RoundCumulatedStatistics extends Observable {
	
	private int totalEatenCakes;
	private int totalEatenPoisonCakes;
	private int totalNutritionistKilled;
	private int totalVirusKilled;
	private int totalScore;
	
	public RoundCumulatedStatistics() {
		super();
		
		resetStatistics();
	}
	
	public int getTotalEatenCakes() {
		return this.totalEatenCakes;
	}
	
	public void setTotalEatenCakes(int totalEatenCakes) {
		this.totalEatenCakes = totalEatenCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalEatenPoisonCakes() {
		return this.totalEatenPoisonCakes;
	}
	
	public void setTotalEatenPoisonCakes(int totalEatenPoisonCakes) {
		this.totalEatenPoisonCakes = totalEatenPoisonCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalNutritionistKilled() {
		return this.totalNutritionistKilled;
	}
	
	public void setTotalNutritionistKilled(int totalNutritionistKilled) {
		this.totalNutritionistKilled = totalNutritionistKilled;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalVirusKilled() {
		return this.totalVirusKilled;
	}
	
	public void setTotalVirusKilled(int totalVirusKilled) {
		this.totalVirusKilled = totalVirusKilled;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalFoodEated() {
		return this.totalEatenCakes + this.totalEatenPoisonCakes;
	}
	
	public int getTotalEnemyKilled() {
		return this.totalNutritionistKilled + this.totalVirusKilled;
	}
	
	public int getTotalScore() {
		return this.totalScore;
	}
	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
		
		setChanged();
		notifyObservers();
	}
	
	public void resetStatistics() {
		setTotalEatenCakes(0);
		setTotalEatenPoisonCakes(0);
		setTotalNutritionistKilled(0);
		setTotalVirusKilled(0);
		setTotalScore(0);
	}
}
