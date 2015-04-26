package game.round;

import java.util.Observable;

public class Score extends Observable {

	private int value;
	
	public Score() {
		super();
		
		this.value = 0;
	}
	
	public Score(int value) {
		this();
		
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
		
		setChanged();
		notifyObservers();
	}
}
