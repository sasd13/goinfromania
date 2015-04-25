package game.element.power;

import game.element.Speed;
import game.element.character.Character;
import game.element.character.Nutritionist;

public class Soporific extends Power {

	/*
	 * Immobilise le nutritionist pendant 5 secondes
	 * Empeche son attaque
	 */
	public static final String NAME = "Soporific";
	public static final int POWER_VALUE_STOP_NUTRITIONIST_MOVE = 5;
	
	public Soporific() {
		super();
		
		setName(NAME);
		setValue(POWER_VALUE_STOP_NUTRITIONIST_MOVE);
	}

	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		Speed speed = nutritionist.getSpeed();
		
		//Pendant 5 secondes
		nutritionist.setPowerful(false);
		speed.setValue(0);
	}
}
