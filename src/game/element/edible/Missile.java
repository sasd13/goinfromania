package game.element.edible;

import game.element.Character;
import game.element.Life;
import game.element.Nutritionist;

public class Missile extends Power {

	public Missile() {
		super();
		
		setTitle("Missile");
	}

	@Override
	public void act(Character character) {
		Nutritionist nutritionist = (Nutritionist) character;
		
		Life life = nutritionist.getLife();
		life.setValue(life.getValue() - getEffect().getValue());
	}
}
