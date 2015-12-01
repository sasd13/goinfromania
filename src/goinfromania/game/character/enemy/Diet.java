package goinfromania.game.character.enemy;

import goinfromania.game.character.Character;
import goinfromania.game.character.Power;

public class Diet extends Power {
	
	@Override
	public void act(Character character) {
		character.setEnergy(character.getEnergy() - getValue());
	}
}
