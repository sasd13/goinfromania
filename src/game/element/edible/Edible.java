package game.element.edible;

import game.element.Element;

public abstract class Edible extends Element {

	private Effect effect;
	
	protected Edible() {
		super();
		
		setTitle("Edible");
		setMovable(false);
		
		this.effect = null;
	}
	
	public Effect getEffect() {
		return this.effect;
	}
	
	public void setEffect(Effect effect) {
		this.effect = effect;
		
		setChanged();
		notifyObservers();
	}
}
