package goinfromania.item;

import goinfromania.Direction;
import goinfromania.Element;
import goinfromania.IEatable;
import goinfromania.IMovable;

public class Cake extends Element implements IMovable, IEatable {

	private boolean nasty;
	private int value, speed;
	
	public Cake() {}
	
	@Override
	public boolean isCrossable() {
		return true;
	}

	@Override
	public boolean isNasty() {
		return nasty;
	}
	
	public void setNasty(boolean nasty) {
		this.nasty = nasty;
	}

	@Override
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean isMovable() {
		return true;
	}
	
	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
