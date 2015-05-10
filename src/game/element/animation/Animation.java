package game.element.animation;

import game.element.Element;

import java.util.Timer;

public abstract class Animation {
	
	public static final int DEFAULT_DURATION = 200;

	private int duration;
	
	protected Timer timer;
	
	protected Animation() {
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
