package game.element.food;

import game.element.Element;
import game.element.character.Pig;

public abstract class Food extends Element {

	private boolean eated;
	private int effectValue;
	
	protected Food() {
		super();
		
		this.eated = false;
		this.effectValue = 0;
	}
	
	public boolean isEated() {
		return this.eated;
	}
	
	public void setEated(boolean eated) {
		this.eated = eated;
		
		setChanged();
		notifyObservers();
		
		if (this.eated) {
			setVisible(false);
		}
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
