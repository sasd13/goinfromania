package game.element.power;

public class SuperMissile extends Missile {

	public static final String NAME = "SuperMissile";
	public static final String IMAGE_NAME = "missile_super.png";
	public static final int VALUE_DECREASE_CHARACTER_LIFE = 2 * Missile.VALUE_DECREASE_CHARACTER_LIFE;
	
	public SuperMissile() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(1);
		setImageName(IMAGE_NAME);
		setPowerValue(VALUE_DECREASE_CHARACTER_LIFE);
	}
}
