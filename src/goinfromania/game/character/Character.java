package goinfromania.game.character;

import goinfromania.Direction;
import goinfromania.Element;
import goinfromania.IMovable;

public abstract class Character extends Element implements ILiveable, IMovable, IEnergetic, IPowerful {
	
	private int life, speed, energy;
	private boolean movable, powerful;
	
	protected Character() {}
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public boolean isAlive() {
		return this.life > 0;
	}
	
	@Override
	public int getLife() {
		return life;
	}
	
	@Override
	public void setLife(int life) {
		this.life = life;
	}

	@Override
	public boolean isMovable() {
		return movable;
	}
	
	@Override
	public void move(Direction direction) {
		//TODO
	}
	
	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
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
	public Power getPowerWithEnergy() {
		return null;
	}
}
