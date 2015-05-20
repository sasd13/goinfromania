package game.element.power;

import game.element.Element;
import game.element.character.Character;

public abstract class Power extends Element {

	private boolean afar;
	private int powerValue;
	
	protected Power() {
		super();
		
		this.afar = false;
		this.powerValue = 0;
	}
	
	public boolean isAfar() {
		return this.afar;
	}
	
	public void setAfar(boolean afar) {
		this.afar = afar;
		
		setChanged();
		notifyObservers();
	}
	
	public int getPowerValue() {
		return this.powerValue;
	}
	
	public void setPowerValue(int powerValue) {
		this.powerValue = powerValue;
		
		setChanged();
		notifyObservers();
	}
	
	public abstract void act(Character characterActor, Character characterToAct);
}
