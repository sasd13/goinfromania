package main.java.game.element.power;

import main.java.game.element.Element;

public abstract class Power extends Element {

	private int powerValue;
	
	protected Power() {
		super();
		
		this.powerValue = 0;
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
