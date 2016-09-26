package com.sasd13.goinfromania.bean.character;

import com.sasd13.goinfromania.bean.Element;
import com.sasd13.goinfromania.bean.IMovable;

public abstract class Character extends Element implements IMovable, ILiveable {

	private boolean movable;
	private int speed, life;

	@Override
	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;

		setChanged();
		notifyObservers();
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;

		setChanged();
		notifyObservers();
	}

	@Override
	public boolean isAlive() {
		return life > 0;
	}

	@Override
	public int getLife() {
		return life;
	}

	@Override
	public void setLife(int life) {
		this.life = life;

		setChanged();
		notifyObservers();
	}
}
