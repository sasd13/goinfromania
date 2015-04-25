package game.element.character;

import game.draw.NutritionistDrawing;
import game.element.power.Diet;

public class Nutritionist extends Character {

	public static final String NAME = "Nutritionist";
	
	private boolean powerful;
	private Diet diet;
	
	public Nutritionist() {
		super();
		
		setTitle(NAME);
		setDrawing(new NutritionistDrawing());
		
		this.powerful = true;
		this.diet = new Diet();
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
