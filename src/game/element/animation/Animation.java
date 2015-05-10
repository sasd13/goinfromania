package game.element.animation;

import game.element.Element;

import java.util.Timer;

public abstract class Animation {
	
	public static final int DEFAULT_DELAY = 200;

	private int delay;
	private Element elementActor;
	private Element elementToAct;
	
	protected Timer timer;
	
	protected Animation() {
		this.delay = DEFAULT_DELAY;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public Element getElementActor() {
		return this.elementActor;
	}
	
	public void setElementActor(Element elementActor) {
		this.elementActor = elementActor;
	}
	
	public Element getElementToAct() {
		return this.elementToAct;
	}
	
	public void setElementToAct(Element elementToAct) {
		this.elementToAct = elementToAct;
	}
	
	public abstract void start();
}
