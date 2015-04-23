package game.element.edible;

import game.element.Pig;

public abstract class Food extends Edible {

	protected Food() {
		super();
		
		setTitle("Food");
	}
	
	public abstract void act(Pig pig);
}
