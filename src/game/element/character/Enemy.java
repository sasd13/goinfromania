package game.element.character;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import game.element.power.Power;

public abstract class Enemy extends Character {

	private static final int DELAY_BEFORE_ENEMY_ATTAK_AGAIN = 2000;
	
	private Power power;
	private int scorePoint;
	
	public Enemy() {
		super();
		
		setPowerful(true);
		
		this.power = null;
		this.scorePoint = 0;
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
	
	public void setPowerlessForDelay() {
		setPowerful(false);
		startDelay();
	}
	
	private synchronized void startDelay() {		
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				setPowerful(true);
				scheduler.shutdown();
			}
		};
		
		scheduler.schedule(runnable, DELAY_BEFORE_ENEMY_ATTAK_AGAIN, TimeUnit.MILLISECONDS);
	}
}
