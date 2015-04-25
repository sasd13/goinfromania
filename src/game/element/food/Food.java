package game.element.food;

import game.element.Element;
import game.element.character.Pig;

public abstract class Food extends Element {

	private int effectValue;
	
	protected Food() {
		super();
		
		this.effectValue = 0;
	}
	
	public int getEffectValue() {
		return this.effectValue;
	}
	
	public void setEffectValue(int effectValue) {
		this.effectValue = effectValue;
		
		setChanged();
		notifyObservers();
	}
	
	public abstract void act(Pig pig);
}
