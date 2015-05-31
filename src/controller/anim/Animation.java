package controller.anim;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class Animation implements ActionListener {
	
	public static final int DEFAULT_DELAY = 200;
	
	protected int count = -1;
	private Timer timer;
	private int duration;
	
	protected Animation() {
		this.timer = new Timer(0, this);
		this.timer.setDelay(DEFAULT_DELAY);
		this.duration = 0;
	}
	
	public int getInitialDelay() {
		return this.timer.getInitialDelay();
	}
	
	public void setInitialDelay(int initialDelay) {
		this.timer.setInitialDelay(initialDelay);
	}
	
	public int getDelay() {
		return this.timer.getDelay();
	}
	
	public void setDelay(int delay) {
		this.timer.setDelay(delay);
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void start() {
		this.timer.start();
	}
	
	public void restart() {
		this.timer.restart();
	}
	
	public void stop() {
		this.timer.stop();
	}
}
