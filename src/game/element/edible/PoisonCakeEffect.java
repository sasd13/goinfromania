package game.element.edible;

public class PoisonCakeEffect extends CakeEffect {

	public static final int VALUE_DECREASE_PIG_ENERGY = 0 - CakeEffect.VALUE_INCREASE_PIG_ENERGY;
	
	public PoisonCakeEffect() {
		super();
		
		setTitle("PoisonCake Effect");
		setValue(VALUE_DECREASE_PIG_ENERGY);
	}
}
