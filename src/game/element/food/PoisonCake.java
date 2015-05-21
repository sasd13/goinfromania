package game.element.food;

public class PoisonCake extends Food {

	public static final int EFFECT_VALUE_DECREASE_PIG_ENERGY = Cake.EFFECT_VALUE_DEFAULT;
	public static final int SCORE_POINT = 0 - Cake.SCORE_POINT_DEFAULT;
	
	protected PoisonCake() {
		super();
		
		setEffectValue(EFFECT_VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
	}
}
