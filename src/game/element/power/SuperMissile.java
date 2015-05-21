package game.element.power;

import anim.ImageAnimation;
import game.element.character.Character;
import game.element.character.Enemy;

public class SuperMissile extends Missile {

	public static final String NAME = "SuperMissile";
	public static final String IMAGENAME = "missile_super.png";
	public static final String ANIMATION_HIT_IMAGE_PREFIX = "hit_";
	public static final String ANIMATION_BOOM_IMAGE_PREFIX = "boom_";
	
	/* 
	 * Quatre fois plus puissant qu'un missile
	 */
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
	
	@Override
	public void act(Character characterActor, Character characterToAct) {
		Enemy enemy = (Enemy) characterToAct;
		
		enemy.setLife(enemy.getLife() - getPowerValue());
		
		ImageAnimation imageAnimation = new ImageAnimation(enemy, ANIMATION_HIT_IMAGE_PREFIX + enemy.getImageName());
		imageAnimation.start();
	}
}
