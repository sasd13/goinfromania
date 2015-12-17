package main.java.game.element.food;

public class PoisonCake extends Food {

	public static final int EFFECT_VALUE_DECREASE_PIG_ENERGY = Cake.EFFECT_VALUE_INCREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 0 - Cake.SCORE_POINT;
	
	protected PoisonCake() {
		super();
		
		setEffectValue(EFFECT_VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
	}
}
