package game.round;

import game.Model;

public class Score extends Model {

	private int value;
	
	public Score() {
		super();
		
		reset();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
		
		notifyObservers();
	}
	
	public void increase(int increaseValue) {
		setValue(this.value + increaseValue);
	}
	
	public void reset() {
		setValue(0);
	}
}
