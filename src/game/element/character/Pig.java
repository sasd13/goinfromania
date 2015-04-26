package game.element.character;

import game.element.draw.PigDrawing;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.power.MapPower;
import game.element.power.Missile;
import game.element.power.Power;
import game.element.power.Paralyze;
import game.element.power.SuperMissile;
import game.round.Score;

public class Pig extends Character {

	public static final String NAME = "Pig";
	
	public static final int ENERGY_MIN = 0;
	public static final int ENERGY_MAX = 100;
	
	public static final int ENERGY_LOW = 20;
	public static final int ENERGY_MEDIUM = 50;
	public static final int ENERGY_HIGH = 80;
	
	private boolean greedy;
	private Energy energy;
	private int countEatenCake;
	
	public Pig() {
		super();
		
		setName(NAME);
		setDrawing(new PigDrawing());
		setPowerful(true);
		
		MapPower mapPower = new MapPower();
		mapPower.put(new Paralyze());
		mapPower.put(new Missile());
		mapPower.put(new SuperMissile());
		setMapPower(mapPower);
		
		this.greedy = true;
		this.energy = new Energy();
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
	
	public Energy getEnergy() {
		return this.energy;
	}
	
	public void setEnergy(Energy energy) {
		this.energy = energy;
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountEatenCake() {
		return this.countEatenCake;
	}
	
	public Score eat(Food food) {
		if (this.greedy) {
			food.act(this);
			
			if (food.getName().compareTo(Cake.NAME) == 0) {
				this.countEatenCake++;
			}
			
			return food.getScore();
		}
		
		return new Score();
	}
	
	@Override
	public Score attak(Character character) {
		if (isPowerful()) {
			Power power = selectPowerWithEnergy();
			power.act(character);
			
			character.checkLife();
			if (character.isDied()) {
				return character.getScore();
			}
		}
		
		return null;
	}
	
	public Power selectPowerWithEnergy() {
		Power power = null;
		
		if (this.energy.getValue() == ENERGY_MAX) {
			power = getMapPower().get(SuperMissile.NAME);
		} else if (this.energy.getValue() < ENERGY_MAX && this.energy.getValue() >= ENERGY_MEDIUM) {
			power = getMapPower().get(Missile.NAME);
		} else {
			power = getMapPower().get(Paralyze.NAME);
		}
		
		return power;
	}
}
