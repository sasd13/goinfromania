package main.java.bean.item;

import java.awt.Dimension;
import java.awt.Point;

import main.java.bean.IEatable;
import main.java.bean.IMovable;

public class Cake implements IMovable, IEatable {

	private String name;
	private Point position;
	private Dimension dimension;
	private int speed, eatValue;
	private boolean nasty;
	
	public Cake() {}
	
	@Override
	public boolean isNasty() {
		return nasty;
	}
	
	@Override
	public void setNasty(boolean nasty) {
		this.nasty = nasty;
	}

	@Override
	public int getEatValue() {
		return eatValue;
	}
	
	@Override
	public void setEatValue(int eatValue) {
		this.eatValue = eatValue;
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
	public void setMovable(boolean movable) {
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
