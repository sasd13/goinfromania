package game.element.power;

import game.element.character.Character;
import game.element.character.Life;

public class Missile extends Power {

	public static final String NAME = "Missile";
	
	/* 
	 * Diminue la vie du nutritioniste de 50
	 */	
	public static final int VALUE_DECREASE_NUTRITIONIST_LIFE = 50;
	
	private int value;
	
	public Missile() {
		super();
		
		setName(NAME);
		
		this.value = VALUE_DECREASE_NUTRITIONIST_LIFE;
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
		Life life = character.getLife();
		life.setValue(life.getValue() - getValue());
	}
}
