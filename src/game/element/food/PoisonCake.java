package game.element.food;

public class PoisonCake extends Cake {
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 0 - Cake.VALUE_EVOLVE_PIG_ENERGY;
	
	public PoisonCake() {
		super();
		
		setTitle("PoisonCake");
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
	}
}
