package game.element;

public class PoisonCakeEffect extends CakeEffect {

	public static final int DEFAULT_DECREASE_VALUE = 0 - CakeEffect.DEFAULT_INCREASE_VALUE;
	
	public PoisonCakeEffect() {
		super();
		
		setTitle("PoisonCake Effect");
		
		setValueModifierPigEnergy(DEFAULT_DECREASE_VALUE);
	}
}
