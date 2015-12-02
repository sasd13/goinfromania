package main.java.bean.item;

import main.java.bean.Element;
import main.java.bean.IEatable;
import main.java.bean.IMovable;

public class Cake extends Element implements IMovable, IEatable {

	private boolean movable, nasty;
	private int speed, eatValue;
	
	public Cake() {}

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
}
