package game.element.character;

import java.awt.image.BufferedImage;

import game.element.power.ListPowers;
import game.element.power.Missile;
import game.element.power.Paralyze;
import game.element.power.Power;
import game.element.power.Run;
import game.element.power.SuperMissile;
import game.util.ImageLoader;

public class Pig extends Character {

	public static final String NAME = "Pig";
	public static final String IMAGE_NAME = "pig.png";
	
	public static final int ENERGY_MIN = 0;	
	public static final int ENERGY_LOW = 20;
	public static final int ENERGY_MEDIUM = 50;
	public static final int ENERGY_HIGH = 80;
	public static final int ENERGY_MAX = 100;
	
	private ListPowers listPowers;
	private boolean greedy;
	private int energy;
	
	public Pig() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setPowerful(true);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
		
		this.listPowers = new ListPowers();
		this.listPowers.add(new Run());
		this.listPowers.add(new Paralyze());
		this.listPowers.add(new Missile());
		this.listPowers.add(new SuperMissile());
		
		this.greedy = true;
		this.energy = ENERGY_MIN;
	}
	
	public ListPowers getListPowers() {
		return this.listPowers;
	}
	
	public void setListPowers(ListPowers listPowers) {
		this.listPowers = listPowers;
		
		setChanged();
		notifyObservers();
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
		if (this.energy == ENERGY_MAX) {
			return this.listPowers.get(SuperMissile.NAME);
		} else if (this.energy < ENERGY_MAX && this.energy >= ENERGY_MEDIUM) {
			return this.listPowers.get(Missile.NAME);
		} else if (this.energy == ENERGY_MIN) {
			return this.listPowers.get(Run.NAME);
		} else {
			return this.listPowers.get(Paralyze.NAME);
		}
	}
}
