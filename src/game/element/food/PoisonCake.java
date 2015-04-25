package game.element.food;

import game.element.draw.PoisonCakeDrawing;

public class PoisonCake extends Cake {
	
	public static final String NAME = "PoisonCake";
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 0 - Cake.VALUE_EVOLVE_PIG_ENERGY;
	
	public PoisonCake() {
		super();
		
		setTitle(NAME);
		setDrawing(new PoisonCakeDrawing());
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
	}
}
