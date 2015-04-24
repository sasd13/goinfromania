package game.element.power;

import game.element.Character;
import game.element.Pig;

public class Diet extends Power {

	/*
	 * Empeche le goinfre de manger pendant 10 secondes
	 * Diminue progressivement son energie
	 */
	public static final int POWER_VALUE_STOP_PIG_EAT = 10;
	
	public Diet() {
		super();
		
		setTitle("Diet");
		setPowerValue(POWER_VALUE_STOP_PIG_EAT);
	}
	
	@Override
	public void act(Character character) {
		Pig pig = (Pig) character;
		
		//Pendant 5 secondes
		pig.setCanEat(false);
	}

}
