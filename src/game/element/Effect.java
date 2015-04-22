package game.element;

import game.Model;

public abstract class Effect extends Model {

	public Effect() {
		super();
	}
	
	public abstract void act(Pig pig);
}
