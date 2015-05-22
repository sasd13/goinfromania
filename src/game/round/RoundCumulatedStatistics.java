package game.round;

import java.util.Observable;

public class RoundCumulatedStatistics extends Observable {
	
	private int totalEatenCakes;
	private int totalEatenPoisonCakes;
	private int totalKilledNutritionists;
	private int totalKilledViruses;
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
	
	public int getTotalKilledNutritionists() {
		return this.totalKilledNutritionists;
	}
	
	public void setTotalKilledNutritionists(int totalKilledNutritionists) {
		this.totalKilledNutritionists = totalKilledNutritionists;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalKilledViruses() {
		return this.totalKilledViruses;
	}
	
	public void setTotalKilledViruses(int totalKilledViruses) {
		this.totalKilledViruses = totalKilledViruses;
		
		setChanged();
		notifyObservers();
	}
	
	public int getTotalFoodEated() {
		return this.totalEatenCakes + this.totalEatenPoisonCakes;
	}
	
	public int getTotalEnemyKilled() {
		return this.totalKilledNutritionists + this.totalKilledViruses;
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
		setTotalKilledNutritionists(0);
		setTotalKilledViruses(0);
		setTotalScore(0);
	}
}
