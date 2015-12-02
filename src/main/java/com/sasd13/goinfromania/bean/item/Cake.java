package com.sasd13.goinfromania.bean.item;

import com.sasd13.goinfromania.bean.Element;
import com.sasd13.goinfromania.bean.IMovable;

public class Cake extends Element implements IEatable, IMovable {

	private boolean nasty, movable;
	private int eatValue, speed;
	
	@Override
	public boolean isNasty() {
		return nasty;
	}
	
	@Override
	public void setNasty(boolean nasty) {
		this.nasty = nasty;
		
		setChanged();
		notifyObservers();
	}

	@Override
	public int getEatValue() {
		return eatValue;
	}
	
	@Override
	public void setEatValue(int eatValue) {
		this.eatValue = eatValue;
		
		setChanged();
		notifyObservers();
	}

	@Override
	public boolean isMovable() {
		return movable;
	}
	
	@Override
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
}
