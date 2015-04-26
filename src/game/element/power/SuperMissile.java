package game.element.power;

public class SuperMissile extends Missile {

	public static final String NAME = "Paralyze";
	
	/* 
	 * Deux fois plus puissant qu'un missile
	 */
	public static final int VALUE_DECREASE_NUTRITIONIST_LIFE = 2 * Missile.VALUE_DECREASE_NUTRITIONIST_LIFE;
	
	public SuperMissile() {
		super();
		
		setName(NAME);
		setValue(VALUE_DECREASE_NUTRITIONIST_LIFE);
	}
}
