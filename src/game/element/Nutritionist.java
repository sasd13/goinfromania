package game.element;

import game.draw.NutritionistDrawing;
import game.element.power.Diet;

public class Nutritionist extends Character {

	private Diet power;
	private boolean canAttak;
	
	public Nutritionist() {
		super();
		
		setTitle("Nutritionist");
		setDrawing(new NutritionistDrawing());
		
		this.canAttak = true;
	}
	
	public boolean getCanAttak() {
		return this.canAttak;
	}
	
	public void setCanAttak(boolean canAttak) {
		this.canAttak = canAttak;
		
		setChanged();
		notifyObservers();
	}
	
	public void attak(Pig pig) {
		if (this.canAttak) {
			this.power.act(pig);
		}
	}
}
