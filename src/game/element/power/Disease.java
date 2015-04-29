package game.element.power;

import java.util.Timer;
import java.util.TimerTask;

import game.element.character.Character;
import game.element.character.Pig;

public class Disease extends Power {

	public static final String NAME = "Disease";
	
	/* 
	 * Ralentit le goinfre pendant 10 secondes et diminue la vie du goinfre de 20
	 */
	public static final int DELAY_DECREASE_PIG_SPEED = 10000;
	public static final int VALUE_DECREASE_PIG_LIFE = 20;
	
	private int delay;
	private int value;
	
	private Timer timerSpeed;
	
	public Disease() {
		super();
		
		setName(NAME);
		
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
		
		this.timerSpeed = new Timer();
		
		pig.setLife(pig.getLife() - getValue());
		pig.setSpeed(SPEED_LOW);
		
		endDiseaseAct(pig);
	}
	
	private synchronized void endDiseaseAct(final Pig pig) {
		this.timerSpeed.cancel();
		this.timerSpeed = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				pig.setSpeed(SPEED_MEDIUM);
			}
		};
		
		this.timerSpeed.schedule(task, getDelay());
	}
}
