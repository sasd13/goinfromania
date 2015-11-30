package goinfromania.game.item;

import goinfromania.game.Element;
import goinfromania.game.IEatable;
import goinfromania.game.IMovable;

public class Cake extends Element implements IMovable, IEatable {

	private boolean nasty;
	private int value, speed;
	
	public Cake() {}
	
	@Override
	public boolean isCrossable() {
		return true;
	}
	
	@Override
	public String getName() {
		return "CAKE";
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
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
