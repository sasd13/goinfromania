package com.sasd13.goinfromania.bean.character.enemy;

import com.sasd13.goinfromania.bean.IPower;
import com.sasd13.goinfromania.bean.IPowerful;
import com.sasd13.goinfromania.bean.character.Character;

public abstract class Enemy extends Character implements IPowerful {
	
	private int energy;
	private boolean powerful;
	
	@Override
	public boolean hasEnergy() {
		return energy > 0;
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
