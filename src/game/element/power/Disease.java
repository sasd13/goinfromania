package game.element.power;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import game.animation.ImageAnimation;
import game.element.character.Character;
import game.element.character.Pig;

public class Disease extends Power {

	public static final String NAME = "Disease";
	public static final String ANIMATION_IMAGE_PREFIX = "disease_";
	
	/* 
	 * Ralentit le goinfre pendant 10 secondes et diminue la vie du goinfre de 20
	 */
	public static final int DELAY_DECREASE_PIG_SPEED = 10000;
	public static final int VALUE_DECREASE_PIG_LIFE = 20;
	
	private int delay;
	private int value;
	
	private ScheduledExecutorService scheduler;
	
	public Disease() {
		super();
		
		setName(NAME);
		
		ImageAnimation animation = new ImageAnimation();
		animation.setImageName(ANIMATION_IMAGE_PREFIX);
		setAnimation(animation);
		
		this.delay = DELAY_DECREASE_PIG_SPEED;
		this.value = VALUE_DECREASE_PIG_LIFE;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
		
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
		
		pig.setLife(pig.getLife() - getValue());
		pig.setSpeed(SPEED_LOW);
		
		this.scheduler = Executors.newScheduledThreadPool(2);
		
		endDiseaseAct(pig);
		
		getAnimation().setDuration(getDelay());
		
		super.act(character);
	}
	
	private synchronized void endDiseaseAct(final Pig pig) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				pig.setSpeed(SPEED_MEDIUM);
			}
		};
		
		this.scheduler.schedule(runnable, getDelay(), TimeUnit.MILLISECONDS);
	}
}
