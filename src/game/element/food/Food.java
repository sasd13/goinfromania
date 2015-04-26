package game.element.food;

import game.element.Element;
import game.element.character.Pig;
import game.round.Score;

public abstract class Food extends Element {

	private String name;
	private Score score;
	private int effectValue;
	
	protected Food() {
		super();
		
		this.name = null;
		this.score = new Score();
		this.effectValue = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		
		setChanged();
		notifyObservers();
	}
	
	public Score getScore() {
		return this.score;
	}
	
	public void setScore(Score score) {
		this.score = score;
		
		setChanged();
		notifyObservers();
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
