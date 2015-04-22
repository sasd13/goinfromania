package game.element;

public class SuperMissilePigPower extends MissilePigPower {

	public static final int DEFAULT_DECREASE_VALUE = 2 * MissilePigPower.DEFAULT_DECREASE_VALUE;
	
	public SuperMissilePigPower() {
		super();
		
		setTitle("SuperMissile PigPower");
		
		setValueDecreaseNutritionistLife(DEFAULT_DECREASE_VALUE);
	}
}
