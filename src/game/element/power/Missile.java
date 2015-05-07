package game.element.power;

import game.element.character.Character;
import game.element.character.Enemy;

public class Missile extends Power {

	public static final String NAME = "Missile";
	
	/* 
	 * Diminue la vie d'un personnage de 25
	 */	
	public static final int VALUE_DECREASE_CHARACTER_LIFE = 25;
	
	private int value;
	
	public Missile() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(SPEED_HIGH);
		
		this.value = VALUE_DECREASE_CHARACTER_LIFE;
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
		Enemy enemy = (Enemy) character;
		
		enemy.setLife(enemy.getLife() - getValue());
	}
}
