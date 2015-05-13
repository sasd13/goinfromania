package game.animation;

import game.element.Element;

import java.util.concurrent.ScheduledExecutorService;

public abstract class Animation {
	
	public static final int DEFAULT_DURATION = 200;

	private int duration;
	
	protected ScheduledExecutorService scheduler;
	
	protected Animation() {
		this.scheduler = null;
		this.duration = DEFAULT_DURATION;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public abstract void start(Element elementActor, Element elementToAct);
}
