package game.element;

import game.Model;

public class Speed extends Model {

	public static final int SPEED_MIN = 0;
	public static final int SPEED_MAX = 50;
	
	public static final int SPEED_LOW = 10;
	public static final int SPEED_MEDIUM = 20;
	public static final int SPEED_HIGH = 30;
	
	private int value;
	
	public Speed() {
		this.value = SPEED_MIN;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
		
		notifyObservers();
	}
}
