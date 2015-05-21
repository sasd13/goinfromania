package game.element.food;

public class PoisonCake extends Food {

	public static final int VALUE_DECREASE_PIG_ENERGY = Cake.VALUE_INCREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 0 - Cake.SCORE_POINT;
	
	protected PoisonCake() {
		super();
		
		setEffectValue(VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
	}
}
