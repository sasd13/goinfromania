package main.java.bean.character.enemy;

import main.java.bean.character.Character;
import main.java.bean.character.Power;

public class Diet extends Power {
	
	@Override
	public void act(Character character) {
		character.setEnergy(character.getEnergy() - getValue());
	}
}
