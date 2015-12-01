package main.java.bean.character.pig;

import main.java.bean.character.Character;
import main.java.bean.character.IPowerful;
import main.java.bean.character.IPower;

public class Pig extends Character implements IPowerful {

	private boolean greedy;
	private boolean powerful;
	private int energy;
	
	public boolean isGreedy() {
		return greedy;
	}
	
	public void setGreedy(boolean greedy) {
		this.greedy = greedy;
	}
	
	@Override
	public boolean hasEnergy() {
		return this.energy > 0;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	@Override
	public boolean isPowerful() {
		return powerful;
	}

	@Override
	public void setPowerful(boolean powerful) {
		this.powerful = powerful;
	}

	@Override
	public IPower getPower() {
		// TODO Auto-generated method stub
		return null;
	}
}
