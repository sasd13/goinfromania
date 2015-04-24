package game.element;

import game.Model;

public class Life extends Model {
	
	public static final int LIFE_MIN = 0;
	public static final int LIFE_MAX = 120;
	
	public static final int LIFE_LOW = 30;
	public static final int LIFE_MEDIUM = 60;
	public static final int LIFE_HIGH = 90;
	
	private int value;
	
	public Life() {
		super();
		
		setTitle("Life");
		
		this.value = LIFE_MAX;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		if (value <= LIFE_MIN) {
			this.value = LIFE_MIN;
		} else if (value >= LIFE_MAX) {
			this.value = LIFE_MAX;
		} else {
			this.value = value;
		}
		
		setChanged();
		notifyObservers();
	}
}
