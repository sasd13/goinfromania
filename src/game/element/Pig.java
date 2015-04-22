package game.element;


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
		
		notifyObservers();
	}
	
	public void eat(Edible edible) {
		edible.getEffect().act(this);
	}
}
