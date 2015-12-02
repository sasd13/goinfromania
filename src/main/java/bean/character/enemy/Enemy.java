package main.java.bean.character.enemy;

import main.java.bean.character.Character;
import main.java.bean.character.IPowerful;
import main.java.bean.character.IPower;

public abstract class Enemy extends Character implements IPowerful {
	
	private boolean powerful;
	private int energy;
	
	protected Enemy() {}
	
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
