package game.element.power;

import game.element.character.Character;
import game.element.character.Pig;

public class Disease extends Power {

	public static final String NAME = "Disease";
	
	/* 
	 * Diminue la vie du goinfre de 20
	 */
	public static final int VALUE_DECREASE_PIG_LIFE = 20;
	
	private int value;
	
	public Disease() {
		super();
		
		setName(NAME);
		
		this.value = VALUE_DECREASE_PIG_LIFE;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void act(Character character) {
		Pig pig = (Pig) character;
		
		pig.setLife(pig.getLife() - getValue());
	}
}
