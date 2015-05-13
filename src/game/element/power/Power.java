package game.element.power;

import game.animation.Animation;
import game.element.Element;
import game.element.character.Character;

public abstract class Power extends Element {

	private boolean afar;
	private Animation animation;
	
	protected Power() {
		super();
		
		this.afar = false;
		this.animation = null;
	}
	
	public boolean isAfar() {
		return this.afar;
	}
	
	public void setAfar(boolean afar) {
		this.afar = afar;
		
		setChanged();
		notifyObservers();
	}
	
	public Animation getAnimation() {
		return this.animation;
	}
	
	public void setAnimation(Animation animation) {
		this.animation = animation;
		
		setChanged();
		notifyObservers();
	}
	
	public void act(Character character) {
		if (this.animation != null) {
			this.animation.start(this, character);
		}
	}
}
