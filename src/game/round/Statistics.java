package game.round;

import java.util.Observable;

public class Statistics extends Observable {
	
	public static final int DEFAULT_MAX_CAKES_TO_EAT = 3;
	public static final int INCREMENTAL_CAKES_TO_EAT = 3;
	
	private int maxCakesToEat;
	
	private int countEatenCakes;
	private int countEatenPoisonCakes;
	private int countKilledNutritionists;
	private int countKilledViruses;
	private int score;
	
	private int totalEatenCakes;
	private int totalEatenPoisonCakes;
	private int totalKilledNutritionists;
	private int totalKilledViruses;
	private int totalScore;
	
	public Statistics() {
		super();
		
		this.maxCakesToEat = DEFAULT_MAX_CAKES_TO_EAT;
		
		resetCounts();
		resetTotals();
	}
	
	public int getMaxCakesToEat() {
		return this.maxCakesToEat;
	}
	
	public void setMaxCakesToEat(int maxCakesToEat) {
		this.maxCakesToEat = maxCakesToEat;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountEatenCakes() {
		return this.countEatenCakes;
	}
	
	public void setCountEatenCakes(int countEatenCakes) {
		this.countEatenCakes = countEatenCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountEatenPoisonCakes() {
		return this.countEatenPoisonCakes;
	}
	
	public void setCountEatenPoisonCakes(int countEatenPoisonCakes) {
		this.countEatenPoisonCakes = countEatenPoisonCakes;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountKilledNutritionists() {
		return this.countKilledNutritionists;
	}
	
	public void setCountKilledNutritionists(int countKilledNutritionists) {
		this.countKilledNutritionists = countKilledNutritionists;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountKilledViruses() {
		return this.countKilledViruses;
	}
	
	public void setCountKilledViruses(int countKilledViruses) {
		this.countKilledViruses = countKilledViruses;
		
		setChanged();
		notifyObservers();
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
		
		setChanged();
		notifyObservers();
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
	
	public int getEatedFoods() {
		return this.countEatenCakes + this.countEatenPoisonCakes;
	}
	
	public int getCountKilledEnemies() {
		return this.countKilledNutritionists + this.countKilledViruses;
	}
	
	public void resetCounts() {
		setCountEatenCakes(0);
		setCountEatenPoisonCakes(0);
		setCountKilledNutritionists(0);
		setCountKilledViruses(0);
		setScore(0);
	}
	
	public void resetTotals() {
		setTotalEatenCakes(0);
		setTotalEatenPoisonCakes(0);
		setTotalKilledNutritionists(0);
		setTotalKilledViruses(0);
		setTotalScore(0);
	}
}
