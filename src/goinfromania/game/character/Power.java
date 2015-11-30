package goinfromania.game.character;

import goinfromania.game.Element;
import goinfromania.game.IMovable;

public abstract class Power extends Element implements IMovable {

	private int value, speed;
	
	protected Power() {}
	
	public abstract void act(Character character);
	
	@Override
	public String getName() {
		return "POWER";
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public boolean isCrossable() {
		return true;
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
