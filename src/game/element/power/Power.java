package game.element.power;

import game.element.Element;
import game.element.animation.Animation;
import game.element.character.Character;

public abstract class Power extends Element {

	private Animation animation;
	
	protected Power() {
		super();
		
		this.animation = null;
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
			this.animation.setElementActor(this);
			this.animation.setElementToAct(character);
			
			this.animation.start();
		}
	}
}
