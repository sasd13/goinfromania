package game.element.food;

import game.element.character.Pig;

public class PoisonCake extends Food {

	public static final int VALUE_DECREASE_PIG_ENERGY = Cake.VALUE_INCREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 0 - Cake.SCORE_POINT;
	
	protected PoisonCake() {
		super();
		
		setEffectValue(VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
	}

	@Override
	public void act(Pig pig) {
		pig.setEnergy(pig.getEnergy() - getEffectValue());
	}
}
