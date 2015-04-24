package game.element;

import game.draw.NutritionistDrawing;
import game.element.power.Diet;

public class Nutritionist extends Character {

	private boolean powerful;
	private Diet diet;
	
	public Nutritionist() {
		super();
		
		setTitle("Nutritionist");
		setDrawing(new NutritionistDrawing());
		
		this.diet = new Diet();
		this.powerful = true;
	}
	
	public boolean isPowerful() {
		return this.powerful;
	}
	
	public void setPowerful(boolean powerful) {
		this.powerful = powerful;
		
		setChanged();
		notifyObservers();
	}
	
	public Diet getDiet() {
		return this.diet;
	}
	
	public void setDiet(Diet diet) {
		this.diet = diet;
		
		setChanged();
		notifyObservers();
	}
	
	public void attak(Pig pig) {
		if (this.powerful) {
			this.diet.act(pig);
		}
	}
}
