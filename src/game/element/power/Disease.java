package game.element.power;

import anim.ImageAnimation;
import anim.power.DiseaseAnimation;
import game.element.character.Character;
import game.element.character.Enemy;
import game.element.character.Pig;

public class Disease extends Power {

	public static final String NAME = "Disease";
	public static final String ANIMATION_IMAGE_PREFIX = "disease_";
	
	/* 
	 * Ralentit le goinfre pendant 8 secondes et diminue la vie du goinfre de 20
	 */
	public static final int DURATION_DECREASE_PIG_SPEED = 8000;
	public static final int VALUE_DECREASE_PIG_LIFE = 20;
	
	public Disease() {
		super();
		
		setName(NAME);
		setPowerValue(VALUE_DECREASE_PIG_LIFE);
	}
	
	@Override
	public void act(Character characterActor, Character characterToAct) {
		Enemy enemy = (Enemy) characterActor;
		Pig pig = (Pig) characterToAct;
		
		DiseaseAnimation diseaseAnimation = new DiseaseAnimation(this, enemy, pig);
		diseaseAnimation.setDelay(DURATION_DECREASE_PIG_SPEED);
		diseaseAnimation.start();
		
		ImageAnimation imageAnimation = new ImageAnimation(pig, ANIMATION_IMAGE_PREFIX + pig.getImageName());
		imageAnimation.setDelay(DURATION_DECREASE_PIG_SPEED);
		imageAnimation.start();
	}
}
