package main.java.game.element.food;

public class Cake extends Food {

	public static final int EFFECT_VALUE_INCREASE_PIG_ENERGY = 15;
	public static final int SCORE_POINT = 50;
	
	protected Cake() {
		super();
		
		setEffectValue(EFFECT_VALUE_INCREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
	}
}
