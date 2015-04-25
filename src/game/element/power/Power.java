package game.element.power;

import game.element.character.Character;

import java.util.Observable;

public abstract class Power extends Observable {

	private String name;
	private int value;
	
	protected Power() {
		super();
		
		this.name = null;
		this.value = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		
		setChanged();
		notifyObservers();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
		
		setChanged();
		notifyObservers();
	}
	
	public abstract void act(Character character);
}
