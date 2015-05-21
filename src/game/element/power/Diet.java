package game.element.power;

import anim.ImageAnimation;
import anim.power.DietAnimation;
import game.element.character.Character;
import game.element.character.Enemy;
import game.element.character.Pig;

public class Diet extends Power {
	
	public static final String NAME = "Diet";
	public static final String ANIMATION_IMAGE_PREFIX = "diet_";
	
	/*
	 * Empeche le goinfre de manger pendant 8 secondes
	 * Diminue de 10 son energie toutes les 2 secondes
	 */	
	public static final int VALUE_DECREASE_PIG_ENERGY = 10;
	public static final int DELAY_DECREASE_PIG_ENERGY = 2000;
	public static final int DURATION_STOP_PIG_EAT = 8000;
	
	public Diet() {
		super();
		
		setName(NAME);
		setPowerValue(VALUE_DECREASE_PIG_ENERGY);
	}
	
	@Override
	public void act(Character characterActor, Character characterToAct) {
		Enemy enemy = (Enemy) characterActor;
		Pig pig = (Pig) characterToAct;
		
		DietAnimation dietAnimation = new DietAnimation(this, enemy, pig);
		dietAnimation.setDelay(DELAY_DECREASE_PIG_ENERGY);
		dietAnimation.setDuration(DURATION_STOP_PIG_EAT);
		dietAnimation.start();
		
		ImageAnimation imageAnimation = new ImageAnimation(pig, ANIMATION_IMAGE_PREFIX + pig.getImageName());
		imageAnimation.setDelay(DURATION_STOP_PIG_EAT);
		imageAnimation.start();
	}
}
