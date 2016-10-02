package com.sasd13.goinfromania.bean.character;

import com.sasd13.goinfromania.bean.IPig;
import com.sasd13.goinfromania.bean.IPower;

public class Pig extends Character implements IPig {

	private boolean greedy, powerful;
	private int energy;

	@Override
	public boolean isGreedy() {
		return greedy;
	}

	@Override
	public void setGreedy(boolean greedy) {
		this.greedy = greedy;

		setChanged();
		notifyObservers();
	}

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
		// TODO Auto-generated method stub
		return null;
	}
}
