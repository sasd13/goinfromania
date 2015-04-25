package game.element.power;

import java.util.Timer;
import java.util.TimerTask;

import game.element.character.Character;
import game.element.character.Energy;
import game.element.character.Pig;

public class Diet extends Power {
	
	/*
	 * Empeche le goinfre de manger pendant 10 secondes
	 * Diminue de 10 son energie toutes les 2 secondes
	 */
	public static final String NAME = "Diet";
	public static final int POWER_DELAY_STOP_PIG_EAT = 10000;
	public static final int DIET_PERIOD_DECREASE_PIG_ENERGY = 2000;
	public static final int DIET_VALUE_DECREASE_PIG_ENERGY = 10;
	
	private int dietPeriod;
	private int dietValue;
	
	private Timer timerPower;
	private Timer timerDiet;
	
	public Diet() {
		super();
		
		setName(NAME);
		setValue(POWER_DELAY_STOP_PIG_EAT);
		
		this.dietPeriod = DIET_PERIOD_DECREASE_PIG_ENERGY;
		this.dietValue = DIET_VALUE_DECREASE_PIG_ENERGY;
	}
	
	public int getDietPeriod() {
		return this.dietPeriod;
	}
	
	public void setDietPeriod(int dietPeriod) {
		this.dietPeriod = dietPeriod;
		
		setChanged();
		notifyObservers();
	}
	
	public int getDietValue() {
		return this.dietValue;
	}
	
	public void setDietValue(int dietValue) {
		this.dietValue = dietValue;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void act(Character character) {
		Pig pig = (Pig) character;
		
		this.timerPower = new Timer();
		this.timerDiet = new Timer();
		
		pig.setGreedy(false);
		startDiectAct(pig.getEnergy());
		endPowerAct(pig);
	}
	
	private synchronized void endPowerAct(final Pig pig) {
		this.timerPower.cancel();
		this.timerPower = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				pig.setGreedy(true);
			}
		};
		
		this.timerPower.schedule(task, getValue());
	}
	
	private synchronized void startDiectAct(final Energy energy) {
		this.timerDiet.cancel();
		this.timerDiet = new Timer();
		
		TimerTask task = new TimerTask() {
			
			private int count = 0;
			
			@Override
			public void run() {
				if(count >= POWER_DELAY_STOP_PIG_EAT / DIET_PERIOD_DECREASE_PIG_ENERGY) {
					timerDiet.cancel();
					timerDiet.purge();
					return;
				}
				energy.setValue(energy.getValue() - getDietValue());
				count++;
			}
		};
		
		this.timerDiet.schedule(task, getDietPeriod(), getDietPeriod());
	}
}
