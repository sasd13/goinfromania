package game.element;

import game.element.food.Food;
import game.element.power.MapPower;
import game.element.power.Missile;
import game.element.power.Power;
import game.element.power.PowerType;
import game.element.power.Soporific;
import game.element.power.SuperMissile;

public class Pig extends Character {

	private boolean greedy;
	private Energy energy;
	private boolean powerful;
	private MapPower mapPower;
	
	public Pig() {
		super();
		
		setTitle("Pig");
		
		this.greedy = true;
		this.energy = new Energy();
		this.powerful = true;
		this.mapPower = new MapPower();
		this.mapPower.put(new Soporific());
		this.mapPower.put(new Missile());
		this.mapPower.put(new SuperMissile());
	}
	
	public boolean isGreedy() {
		return this.greedy;
	}
	
	public void setGreedy(boolean greedy) {
		this.greedy = greedy;
		
		setChanged();
		notifyObservers();
	}
	
	public Energy getEnergy() {
		return this.energy;
	}
	
	public void setEnergy(Energy energy) {
		this.energy = energy;
		
		setChanged();
		notifyObservers();
	}
	
	public MapPower getMapPower() {
		return this.mapPower;
	}
	
	public void setMapPower(MapPower mapPower) {
		this.mapPower = mapPower;
		
		setChanged();
		notifyObservers();
	}
	
	public boolean isPowerful() {
		return this.powerful;
	}
	
	public void setPowerful(boolean powerful) {
		this.powerful = powerful;
		
		setChanged();
		notifyObservers();
	}
	
	public void attak(Nutritionist nutritionist) {
		if (this.powerful) {
			Power power = selectPowerWithEnergy();
			power.act(nutritionist);
		}
	}
	
	public Power selectPowerWithEnergy() {
		Power power = null;
		
		Energy energy = getEnergy();
		if (energy.getValue() == Energy.ENERGY_MAX) {
			power = this.mapPower.get(PowerType.SUPERMISSILE);
		} else if (energy.getValue() < Energy.ENERGY_MAX && energy.getValue() >= Energy.ENERGY_MEDIUM) {
			power = this.mapPower.get(PowerType.MISSILE);
		} else {
			power = this.mapPower.get(PowerType.SOPORIFIC);
		}
		
		return power;
	}
	
	public void eat(Food food) {
		if (this.greedy) {
			food.act(this);
		}
	}
}
