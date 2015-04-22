package game.element;

import game.Model;

public abstract class Power extends Model {

	private boolean enabled;
	
	public Power() {
		super();
		
		setTitle("Power");
		
		this.enabled = true;
	}
	
	public boolean getEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		
		setChanged();
		notifyObservers();
	}
	
	public abstract void act(Character character);
}
