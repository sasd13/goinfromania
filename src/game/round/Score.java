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
	
	public void reset() {
		this.value = 0;
		
		notifyObservers();
	}
}
