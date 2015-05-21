package game.element.power;

import anim.ImageAnimation;
import game.element.character.Character;
import game.element.character.Enemy;

public class Missile extends Power {

	public static final String NAME = "Missile";
	public static final String IMAGENAME = "missile.png";
	public static final String ANIMATION_HIT_IMAGE_PREFIX = "hit_";
	public static final String ANIMATION_BOOM_IMAGE_PREFIX = "boom_";
	
	/* 
	 * Diminue la vie d'un personnage de 25
	 */	
	public static final int VALUE_DECREASE_CHARACTER_LIFE = 25;
	
	public Missile() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(2);
		setImageName(IMAGENAME);
		setAfar(true);
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
