package game.element.power;

import game.element.Character;
import game.element.Life;
import game.element.Nutritionist;

public class Missile extends Power {

	public static final int POWER_VALUE_DECREASE_NUTRITIONIST_LIFE = 50;
	
	public Missile() {
		super();
		
		setTitle("Missile");
		setPowerValue(POWER_VALUE_DECREASE_NUTRITIONIST_LIFE);
	}

	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		Life life = nutritionist.getLife();
		life.setValue(life.getValue() - getPowerValue());
	}
}
