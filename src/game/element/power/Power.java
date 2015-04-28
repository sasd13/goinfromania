package game.element.power;

import game.element.Element;
import game.element.character.Character;

public abstract class Power extends Element {

	protected Power() {
		super();
	}
	
	public abstract void act(Character character);
}
