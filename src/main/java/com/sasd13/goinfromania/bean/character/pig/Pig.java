package com.sasd13.goinfromania.bean.character.pig;

import com.sasd13.goinfromania.bean.character.Character;
import com.sasd13.goinfromania.bean.character.IPowerful;
import com.sasd13.goinfromania.bean.character.IPower;

public class Pig extends Character implements IPowerful {

	private boolean greedy, powerful;
	private int energy;
	
	public boolean isGreedy() {
		return greedy;
	}
	
	public void setGreedy(boolean greedy) {
		this.greedy = greedy;
		
		setChanged();
		notifyObservers();
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
		
		setChanged();
		notifyObservers();
	}

	@Override
	public boolean isPowerful() {
		return powerful;
	}

	@Override
	public void setPowerful(boolean powerful) {
		this.powerful = powerful;
		
		setChanged();
		notifyObservers();
	}

	@Override
	public IPower getPower() {
		// TODO Auto-generated method stub
		return null;
	}
}
