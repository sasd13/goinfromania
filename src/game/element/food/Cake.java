package game.element.food;

import game.element.character.Pig;

public class Cake extends Food {

	public static final int VALUE_INCREASE_PIG_ENERGY = 15;
	public static final int SCORE_POINT = 50;
	
	protected Cake() {
		super();
		
		setEffectValue(VALUE_INCREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
	}
	
	@Override
	public void act(Pig pig) {
		pig.setEnergy(pig.getEnergy() + getEffectValue());
	}
}
