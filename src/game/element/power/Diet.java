package game.element.power;

import java.util.Timer;
import java.util.TimerTask;

import game.element.animation.ImageAnimation;
import game.element.character.Character;
import game.element.character.Pig;

public class Diet extends Power {
	
	public static final String NAME = "Diet";
	public static final String ANIMATION_IMAGE_PREFIX = "diet_";
	
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
	
	private Timer timerEat;
	private Timer timerEnergy;
	
	public Diet() {
		super();
		
		setName(NAME);
		
		ImageAnimation animation = new ImageAnimation();
		animation.setImageName(ANIMATION_IMAGE_PREFIX);
		setAnimation(animation);
		
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
		
		this.timerEat = new Timer();
		this.timerEnergy = new Timer();
		
		pig.setGreedy(false);
		startDietAct(pig);
		endDietAct(pig);
		
		getAnimation().setDelay(getDelay());
		
		super.act(character);
	}
	
	private synchronized void startDietAct(final Pig pig) {
		this.timerEnergy.cancel();
		this.timerEnergy = new Timer();
		
		TimerTask task = new TimerTask() {
			
			private int count = 0;
			
			@Override
			public void run() {
				if (count >= DELAY_STOP_PIG_EAT / PERIOD_DECREASE_PIG_ENERGY) {
					timerEnergy.cancel();
					timerEnergy.purge();
					return;
				}
				pig.setEnergy(pig.getEnergy() - getValue());
				count++;
			}
		};
		
		this.timerEnergy.schedule(task, getPeriod(), getPeriod());
	}
	
	private synchronized void endDietAct(final Pig pig) {
		this.timerEat.cancel();
		this.timerEat = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				pig.setGreedy(true);
			}
		};
		
		this.timerEat.schedule(task, getDelay());
	}
}
