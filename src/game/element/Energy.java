package game.element;

import game.Model;

public class Energy extends Model {
	
	public static final int ENERGY_MIN = 0;
	public static final int ENERGY_MAX = 120;
	
	public static final int ENERGY_LOW = 30;
	public static final int ENERGY_MEDIUM = 60;
	public static final int ENERGY_HIGH = 90;
	
	private int value;
	
	public Energy() {
		super();
		
		setTitle("Energy");
		
		this.value = ENERGY_MIN;
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
