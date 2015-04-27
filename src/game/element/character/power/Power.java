package game.element.character.power;

import game.element.character.Character;

import java.util.Observable;

public abstract class Power extends Observable {

	private String name;
	
	protected Power() {
		super();
		
		this.name = null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		
		setChanged();
		notifyObservers();
	}
	
	public abstract void act(Character character);
}
