package goinfromania.game.character.pig;

import goinfromania.IEatable;
import goinfromania.game.character.Character;
import goinfromania.game.character.Power;
import goinfromania.game.character.enemy.Enemy;

public class Pig extends Character {

	private boolean greedy;
	
	public Pig() {}
	
	public boolean isGreedy() {
		return greedy;
	}
	
	public void setGreedy(boolean greedy) {
		this.greedy = greedy;
	}
	
	public void eat(IEatable eatable) {
		if (isGreedy()) {
			if (eatable.isNasty()) {
				setEnergy(getEnergy() - eatable.getValue()); 
			} else {
				setEnergy(getEnergy() + eatable.getValue());
			}
		}
	}
	
	public void attakEnemy(Enemy enemy) {
		if (isPowerful()) {
			getPowerWithEnergy().act(enemy);
		}
	}
	
	@Override
	public Power getPowerWithEnergy() {
		if (getEnergy() < ENERGY_MEDIUM) {
			return new Paralyze();
		} else if (getEnergy() < ENERGY_MAX) {
			return new Missile();
		}
		
		return super.getPowerWithEnergy();
	}
}
