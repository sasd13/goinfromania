package main.java.bean.character.pig;

import main.java.bean.IEatable;
import main.java.bean.character.Character;
import main.java.bean.character.Power;
import main.java.bean.character.enemy.Enemy;

public class Pig extends Character {

	private boolean greedy;
	
	public Pig() {
		setLife(LIFE_MAX);
	}
	
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
