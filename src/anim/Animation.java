package anim;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class Animation implements ActionListener {
	
	public static final int DEFAULT_DELAY = 200;

	private int initialDelay, delay, duration;
	
	protected int count = -1;
	protected Timer timer;
	
	protected Animation() {
		this.initialDelay = 0;
		this.delay = DEFAULT_DELAY;
		this.duration = 0;
	}
	
	public int getInitialDelay() {
		return this.initialDelay;
	}
	
	public void setInitialDelay(int initialDelay) {
		this.initialDelay = initialDelay;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void start() {
		this.timer = new Timer(this.initialDelay, this);
		this.timer.setDelay(this.delay);
		this.timer.start();
	}
	
	public void restart() {
		this.timer.restart();
	}
	
	public void stop() {
		this.timer.stop();
	}
}
