package main.java.bean.character.enemy;

import main.java.bean.character.Character;
import main.java.bean.character.pig.Pig;

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
