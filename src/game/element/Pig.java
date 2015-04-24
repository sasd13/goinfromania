package game.element;

import game.element.food.Food;
import game.element.power.MapPower;
import game.element.power.Missile;
import game.element.power.Power;
import game.element.power.PowerType;
import game.element.power.Soporific;
import game.element.power.SuperMissile;

public class Pig extends Character {

	private Energy energy;
	private MapPower mapPower;
	private boolean canAttak;
	private boolean canEat;
	
	public Pig() {
		super();
		
		setTitle("Pig");
		
		this.energy = new Energy();
		this.canAttak = true;
		this.mapPower = new MapPower();
		this.mapPower.put(new Soporific());
		this.mapPower.put(new Missile());
		this.mapPower.put(new SuperMissile());
		this.canEat = true;
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
	}
	
	public boolean getCanAttak() {
		return this.canAttak;
	}
	
	public void setCanAttak(boolean canAttak) {
		this.canAttak = canAttak;
		
		setChanged();
		notifyObservers();
	}
	
	public void attak(Nutritionist nutritionist) {
		if (this.canAttak) {
			Power power = selectPowerWithEnergy();
			power.act(nutritionist);
		}
	}
	
	private Power selectPowerWithEnergy() {
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
	
	public boolean getCanEat() {
		return this.canEat;
	}
	
	public void setCanEat(boolean canEat) {
		this.canEat = canEat;
	}
	
	public void eat(Food food) {
		if (this.canEat) {
			food.act(this);
		}
	}
}
