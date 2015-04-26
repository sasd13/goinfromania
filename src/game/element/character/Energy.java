package game.element.character;

import java.util.Observable;

public class Energy extends Observable {

	public static final int ENERGY_MIN = 0;
	public static final int ENERGY_MAX = 100;
	
	public static final int ENERGY_LOW = 20;
	public static final int ENERGY_MEDIUM = 50;
	public static final int ENERGY_HIGH = 80;
	
	private int value;
	
	public Energy() {
		super();
		
		this.value = ENERGY_MIN;
	}
	
	public Energy(int value) {
		this();
		
		setValue(value);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		if (value <= ENERGY_MIN) {
			this.value = ENERGY_MIN;
		} else if (value >= ENERGY_MAX) {
			this.value = ENERGY_MAX;
		} else {
			this.value = value;
		}
		
		setChanged();
		notifyObservers();
	}
}
