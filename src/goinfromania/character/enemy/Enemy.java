package goinfromania.character.enemy;

import goinfromania.character.Character;
import goinfromania.character.pig.Pig;

public class Enemy extends Character {
	
	public Enemy() {}
	
	public void attakPig(Pig pig) {
		if (isPowerful()) {
			getPowerWithEnergy().act(pig);
		}
	}
}
