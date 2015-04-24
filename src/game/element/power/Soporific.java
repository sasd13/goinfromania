package game.element.power;

import game.element.Character;
import game.element.Nutritionist;
import game.element.Speed;

public class Soporific extends Power {

	/*
	 * Immobilise le nutritionist pendant 5 secondes
	 * Empeche son attaque
	 */
	public static final int POWER_VALUE_STOP_NUTRITIONIST_MOVE = 5;
	
	public Soporific() {
		super();
		
		setTitle("Soporific");
		setPowerValue(POWER_VALUE_STOP_NUTRITIONIST_MOVE);
	}

	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		Speed speed = nutritionist.getSpeed();
		
		//Pendant 5 secondes
		nutritionist.setCanAttak(false);
		speed.setValue(0);
	}
}
