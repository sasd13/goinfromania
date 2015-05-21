package game.element.power;

public class SuperMissile extends Missile {

	public static final String NAME = "SuperMissile";
	public static final String IMAGENAME = "missile_super.png";
	public static final int VALUE_DECREASE_CHARACTER_LIFE = 4 * Missile.VALUE_DECREASE_CHARACTER_LIFE;
	
	public SuperMissile() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(1);
		setAfar(true);
		setImageName(IMAGENAME);
		setPowerValue(VALUE_DECREASE_CHARACTER_LIFE);
	}
}
