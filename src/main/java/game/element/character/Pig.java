package main.java.game.element.character;

import java.awt.Point;
import java.awt.image.BufferedImage;

import main.java.game.element.Direction;
import main.java.game.element.power.Missile;
import main.java.game.element.power.Paralyze;
import main.java.game.element.power.Power;
import main.java.game.element.power.SuperMissile;
import main.java.util.ElementUtil;
import main.java.util.ImageLoader;

public class Pig extends Character {

	public static final String NAME = "Pig";
	public static final String IMAGE_NAME = "pig.png";
	
	public static final int ENERGY_MIN = 0;	
	public static final int ENERGY_LOW = 20;
	public static final int ENERGY_MEDIUM = 50;
	public static final int ENERGY_HIGH = 80;
	public static final int ENERGY_MAX = 100;
	
	public static final int SPEED_MIN = 0;
	public static final int SPEED_LOW = 20;
	public static final int SPEED_MEDIUM = 50;
	public static final int SPEED_HIGH = 80;
	public static final int SPEED_MAX = 100;
	
	private boolean greedy;
	private int energy;
	
	public Pig() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setSpeed(SPEED_MEDIUM);
		setPowerful(true);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
		
		this.greedy = true;
		this.energy = ENERGY_MIN;
	}
	
	@Override
	public Point getNextPosition(Direction direction) {
		Point nextPosition = super.getNextPosition(direction);
		
		nextPosition = ElementUtil.recalibration(nextPosition, direction, getSpeed()); //Repositionnement
		
		return nextPosition;
	}
	
	public boolean isGreedy() {
		return this.greedy;
	}
	
	public void setGreedy(boolean greedy) {
		this.greedy = greedy;
		
		setChanged();
		notifyObservers();
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public void setEnergy(int energy) {
		if (energy < ENERGY_MIN) {
			this.energy = ENERGY_MIN;
		} else if (energy > ENERGY_MAX) {
			this.energy = ENERGY_MAX;
		} else {
			this.energy = energy;
		}
		
		setChanged();
		notifyObservers();
	}
	
	public Power getPowerWithEnergy() {
		if (this.energy < ENERGY_MEDIUM) {
			return new Paralyze();
		} else if (this.energy < ENERGY_MAX) {
			return new Missile();
		} else {
			return new SuperMissile();
		}
	}
}
