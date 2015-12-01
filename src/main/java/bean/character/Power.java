package main.java.bean.character;

import java.awt.Dimension;
import java.awt.Point;

import main.java.bean.IMovable;

public abstract class Power implements IMovable {

	private int value, speed;
	private String name;
	private Point position;
	private Dimension dimension;
	
	protected Power() {}
	
	public abstract void act(Character character);
	
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
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Point getPosition() {
		return position;
	}
	
	@Override
	public void setPosition(Point position) {
		this.position = position;
	}
	
	@Override
	public Dimension getDimension() {
		return dimension;
	}
	
	@Override
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
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
