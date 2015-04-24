package game.element;

import game.Model;

public class Speed extends Model {

	public static final int SPEED_MIN = 0;
	public static final int SPEED_MAX = 50;
	
	public static final int SPEED_LOW = 10;
	public static final int SPEED_MEDIUM = 25;
	public static final int SPEED_HIGH = 40;
	
	private int value;
	
	public Speed() {
		super();
		
		setTitle("Speed");
		
		this.value = SPEED_MIN;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		if(value <= SPEED_MIN) {
			this.value = SPEED_MIN;
		} else if (value >= SPEED_MAX) {
			this.value = SPEED_MAX;
		} else {
			this.value = value;
		}
		
		setChanged();
		notifyObservers();
	}
}
