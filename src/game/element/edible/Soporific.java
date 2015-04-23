package game.element.edible;

import game.element.Character;
import game.element.Nutritionist;
import game.element.Speed;

public class Soporific extends Power {

	public Soporific() {
		super();
		
		setTitle("Soporific PigPower");
	}

	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		Speed speed = nutritionist.getSpeed();
		speed.setValue(0);
	}
}
