package goinfromania.game.character.enemy;

import goinfromania.game.character.Character;
import goinfromania.game.character.pig.Pig;

public class Enemy extends Character {
	
	public Enemy() {}
	
	public void attakPig(Pig pig) {
		if (isPowerful()) {
			getPowerWithEnergy().act(pig);
		}
	}
}
