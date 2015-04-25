package game.element.power;

import game.element.character.Character;
import game.element.character.Life;
import game.element.character.Nutritionist;

public class Missile extends Power {

	public static final String NAME = "Missile";
	public static final int POWER_VALUE_DECREASE_NUTRITIONIST_LIFE = 50;
	
	public Missile() {
		super();
		
		setName(NAME);
		setValue(POWER_VALUE_DECREASE_NUTRITIONIST_LIFE);
	}

	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		Life life = nutritionist.getLife();
		life.setValue(life.getValue() - getValue());
	}
}
