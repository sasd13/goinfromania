package game.element.edible;

import game.element.Character;

public abstract class Power extends Edible {

	protected Power() {
		super();
		
		setTitle("Power");
	}
	
	public abstract void act(Character character);
}
