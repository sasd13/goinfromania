package game.element.power;

public class SuperMissile extends Missile {

	public static final String NAME = "SuperMissile";
	public static final int POWER_VALUE_DECREASE_NUTRITIONIST_LIFE = 2 * Missile.POWER_VALUE_DECREASE_NUTRITIONIST_LIFE;
	
	public SuperMissile() {
		super();
		
		setName(NAME);
		setValue(POWER_VALUE_DECREASE_NUTRITIONIST_LIFE);
	}
}
