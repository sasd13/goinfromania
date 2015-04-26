package game.element.power;

import java.util.Timer;
import java.util.TimerTask;

import game.element.character.Character;
import game.element.character.Energy;
import game.element.character.Pig;

public class Diet extends Power {
	
	public static final String NAME = "Diet";
	
	/*
	 * Empeche le goinfre de manger pendant 10 secondes
	 * Diminue de 8 son energie toutes les 2 secondes
	 */	
	public static final int DELAY_STOP_PIG_EAT = 10000;
	public static final int PERIOD_DECREASE_PIG_ENERGY = 2000;
	public static final int VALUE_DECREASE_PIG_ENERGY = 8;
	
	private int delay;
	private int period;
	private int value;
	
	private Timer timerPower;
	private Timer timerDiet;
	
	public Diet() {
		super();
		
		setName(NAME);
		
		this.delay = DELAY_STOP_PIG_EAT;
		this.period = PERIOD_DECREASE_PIG_ENERGY;
		this.value = VALUE_DECREASE_PIG_ENERGY;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
		
		setChanged();
		notifyObservers();
	}
	
	public int getPeriod() {
		return this.period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
		
		setChanged();
		notifyObservers();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void act(Character character) {
		Pig pig = (Pig) character;
		
		this.timerPower = new Timer();
		this.timerDiet = new Timer();
		
		pig.setGreedy(false);
		startDiectAct(pig);
		endPowerAct(pig);
	}
	
	private synchronized void startDiectAct(final Pig pig) {
		this.timerDiet.cancel();
		this.timerDiet = new Timer();
		
		TimerTask task = new TimerTask() {
			
			private int count = 0;
			
			@Override
			public void run() {
				if(count >= DELAY_STOP_PIG_EAT / PERIOD_DECREASE_PIG_ENERGY) {
					timerDiet.cancel();
					timerDiet.purge();
					return;
				}
				Energy energy = pig.getEnergy();
				energy.setValue(energy.getValue() - getValue());
				count++;
			}
		};
		
		this.timerDiet.schedule(task, getPeriod(), getPeriod());
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
		
		this.timerPower.schedule(task, getDelay());
	}
}
