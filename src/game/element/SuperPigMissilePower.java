package game.element;

public class SuperPigMissilePower extends MissilePigPower {

	public static final int DEFAULT_DECREASE_VALUE = 2 * MissilePigPower.DEFAULT_DECREASE_VALUE;
	
	public SuperPigMissilePower() {
		super();
		
		setValueDecreaseNutritionistLife(DEFAULT_DECREASE_VALUE);
	}
}
