package game.element.food;

import game.element.Element;
import game.element.animation.Animation;
import game.element.character.Pig;

public abstract class Food extends Element {

	private boolean eated;
	private int effectValue;
	private int scorePoint;
	private Animation animation;
	
	protected Food() {
		super();
		
		this.eated = false;
		this.effectValue = 0;
		this.scorePoint = 0;
		this.animation = null;
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
	
	public int getScorePoint() {
		return this.scorePoint;
	}
	
	public void setScorePoint(int scorePoint) {
		this.scorePoint = scorePoint;
		
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
	
	public void act(Pig pig) {
		if (this.animation != null) {
			this.animation.setElementActor(this);
			this.animation.setElementToAct(pig);
			
			this.animation.start();
		}
	}
}
