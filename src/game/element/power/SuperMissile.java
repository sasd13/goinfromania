package game.element.power;

public class SuperMissile extends Missile {

	public static final String NAME = "SuperMissile";
	
	/* 
	 * Quatre fois plus puissant qu'un missile
	 */
	public static final int VALUE_DECREASE_CHARACTER_LIFE = 4 * Missile.VALUE_DECREASE_CHARACTER_LIFE;
	
	public SuperMissile() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(SPEED_LOW);
		setAfar(true);
		setPowerValue(VALUE_DECREASE_CHARACTER_LIFE);
	}
}
