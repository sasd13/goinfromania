package game.element;

import game.element.edible.Edible;


public class Pig extends Character {

	private Energy energy;
	
	public Pig() {
		super();
		
		setTitle("Pig");
		
		this.energy = new Energy();
	}
	
	public Energy getEnergy() {
		return this.energy;
	}
	
	public void setEnergy(Energy energy) {
		this.energy = energy;
		
		setChanged();
		notifyObservers();
	}
	
	public void eat(Edible edible) {
		edible.getEffect().act(this);
	}
}
