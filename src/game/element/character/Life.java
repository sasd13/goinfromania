package game.element.character;

import java.util.Observable;

public class Life extends Observable {
	
	public static final String NAME = "Life";
	
	public static final int LIFE_MIN = 0;
	public static final int LIFE_MAX = 120;
	
	public static final int LIFE_LOW = 30;
	public static final int LIFE_MEDIUM = 60;
	public static final int LIFE_HIGH = 90;
	
	private int value;
	
	public Life() {
		super();
		
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
