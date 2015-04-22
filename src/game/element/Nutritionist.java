package game.element;

import game.draw.NutritionistDrawing;

public class Nutritionist extends Character {

	public Nutritionist() {
		super();
		
		setTitle("Nutritionist");
		
		setDrawing(new NutritionistDrawing());
	}
}
