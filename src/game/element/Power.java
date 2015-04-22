package game.element;

public abstract class Power {

	private boolean enabled;
	
	public Power() {
		this.enabled = true;
	}
	
	public boolean getEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public abstract void act(Character character);
}
