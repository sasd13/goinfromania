package game.element.power;

public class SuperMissile extends Missile {

	public static final int POWER_VALUE_DECREASE_NUTRITIONIST_LIFE = 2 * Missile.POWER_VALUE_DECREASE_NUTRITIONIST_LIFE;
	
	public SuperMissile() {
		super();
		
		setTitle("SuperMissile");
		setPowerValue(POWER_VALUE_DECREASE_NUTRITIONIST_LIFE);
	}
}
