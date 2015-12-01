package main.java.bean.character;

import java.awt.Dimension;
import java.awt.Point;

import main.java.bean.IMovable;

public abstract class Character implements IMovable, ILiveable, IEnergetic, IPowerful {
	
	private String name;
	private Point position;
	private Dimension dimension;
	private boolean movable, powerful;
	private int life, speed, energy;
	
	protected Character() {}
	
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
		return movable;
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
