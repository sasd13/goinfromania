package game.element.character;

import game.element.draw.PigDrawing;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.power.MapPower;
import game.element.power.Missile;
import game.element.power.Paralyze;
import game.element.power.Power;
import game.element.power.Run;
import game.element.power.SuperMissile;

public class Pig extends Character {

	public static final String NAME = "Pig";
	
	public static final int ENERGY_MIN = 0;
	public static final int ENERGY_MAX = 100;
	
	public static final int ENERGY_LOW = 20;
	public static final int ENERGY_MEDIUM = 50;
	public static final int ENERGY_HIGH = 80;
	
	private boolean greedy;
	private int energy;
	private int countEatenCake;
	
	public Pig() {
		super();
		
		setName(NAME);
		setDrawing(new PigDrawing());
		setPowerful(true);
		
		MapPower mapPower = new MapPower();
		mapPower.put(new Run());
		mapPower.put(new Paralyze());
		mapPower.put(new Missile());
		mapPower.put(new SuperMissile());
		setMapPower(mapPower);
		
		this.greedy = true;
		this.energy = ENERGY_MIN;
		this.countEatenCake = 0;
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
	
	public int getCountEatenCake() {
		return this.countEatenCake;
	}
	
	@Override
	public void attak(Character character) {
		if (isPowerful()) {
			Power power = getPowerWithEnergy();
			power.setPosition(getPosition());
			power.act(character);
		}
	}
	
	public void eat(Food food) {
		if (this.greedy) {
			food.setEated(true);
			food.act(this);
			
			if (food.getName().compareTo(Cake.NAME) == 0) {
				this.countEatenCake++;
			}
		}
	}
	
	public Power getPowerWithEnergy() {
		Power power = null;
		
		if (this.energy == ENERGY_MAX) {
			power = getMapPower().get(SuperMissile.NAME);
		} else if (this.energy < ENERGY_MAX && this.energy >= ENERGY_MEDIUM) {
			power = getMapPower().get(Missile.NAME);
		} else if (this.energy == ENERGY_MIN) {
			power = getMapPower().get(Run.NAME);
		} else {
			power = getMapPower().get(Paralyze.NAME);
		}
		
		return power;
	}
}
