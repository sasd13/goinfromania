package game.element.power;

import game.element.Element;

public abstract class Power extends Element {

	private boolean used;
	private int powerValue;
	
	protected Power() {
		super();
		
		this.used = false;
		this.powerValue = 0;
	}
	
	public boolean isUsed() {
		return this.used;
	}
	
	public void setUsed(boolean used) {
		this.used = used;
		
		setChanged();
		notifyObservers();
	}
	
	public int getPowerValue() {
		return this.powerValue;
	}
	
	public void setPowerValue(int powerValue) {
		this.powerValue = powerValue;
		
		setChanged();
		notifyObservers();
	}
}
