package goinfromania.game.character.enemy;

import goinfromania.game.character.Character;
import goinfromania.game.character.pig.Pig;

public abstract class Enemy extends Character {
	
	protected Enemy() {}
	
	@Override
	public String getName() {
		return "ENEMY";
	}
	
	public void attakPig(Pig pig) {
		if (isPowerful()) {
			getPowerWithEnergy().act(pig);
		}
	}
}
