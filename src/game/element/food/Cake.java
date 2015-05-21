package game.element.food;

public class Cake extends Food {

	public static final int EFFECT_VALUE_DEFAULT = 15;
	public static final int SCORE_POINT_DEFAULT = 50;
	
	protected Cake() {
		super();
		
		setEffectValue(EFFECT_VALUE_DEFAULT);
		setScorePoint(SCORE_POINT_DEFAULT);
	}
}
