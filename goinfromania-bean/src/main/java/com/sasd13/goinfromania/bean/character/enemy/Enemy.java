package com.sasd13.goinfromania.bean.character.enemy;

import com.sasd13.goinfromania.bean.character.Character;
import com.sasd13.goinfromania.bean.character.IPowerful;
import com.sasd13.goinfromania.bean.character.IPower;

public abstract class Enemy extends Character implements IPowerful {
	
	private int energy;
	private boolean powerful;
	
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
		return null;
	}
}
