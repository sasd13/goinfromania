package game.element.character;

import game.element.draw.PigDrawing;
import game.element.food.Food;
import game.element.power.MapPower;
import game.element.power.Missile;
import game.element.power.Power;
import game.element.power.Paralyze;
import game.element.power.SuperMissile;

public class Pig extends Character {

	public static final String NAME = "Pig";
	
	private boolean greedy;
	private Energy energy;
	
	public Pig() {
		super();
		
		setTitle(NAME);
		setDrawing(new PigDrawing());
		setPowerful(true);
		
		MapPower mapPower = new MapPower();
		mapPower.put(new Paralyze());
		mapPower.put(new Missile());
		mapPower.put(new SuperMissile());
		
		setMapPower(mapPower);
		
		this.greedy = true;
		this.energy = new Energy();		
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
	
	public void eat(Food food) {
		if (this.greedy) {
			food.act(this);
		}
	}
	
	@Override
	public void attak(Character character) {
		if (isPowerful()) {
			Nutritionist nutritionist = (Nutritionist) character;
			
			Power power = selectPowerWithEnergy();
			power.act(nutritionist);
		}
	}
	
	public Power selectPowerWithEnergy() {
		Power power = null;
		
		Energy energy = getEnergy();
		if (energy.getValue() == Energy.ENERGY_MAX) {
			power = getMapPower().get(SuperMissile.NAME);
		} else if (energy.getValue() < Energy.ENERGY_MAX && energy.getValue() >= Energy.ENERGY_MEDIUM) {
			power = getMapPower().get(Missile.NAME);
		} else {
			power = getMapPower().get(Paralyze.NAME);
		}
		
		return power;
	}
}
