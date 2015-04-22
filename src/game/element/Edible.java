package game.element;

public abstract class Edible extends Element {

	private Effect effect;
	
	public Edible() {
		super();
		
		setTitle("Edible");
		
		this.effect = null;
	}
	
	public Effect getEffect() {
		return this.effect;
	}
	
	public void setEffect(Effect effect) {
		this.effect = effect;
		
		notifyObservers();
	}
}
