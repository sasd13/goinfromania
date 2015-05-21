package game.element.power;

import anim.ImageAnimation;
import anim.power.ParalyzeAnimation;
import game.element.character.Character;
import game.element.character.Enemy;
import game.element.character.Pig;

public class Paralyze extends Power {

	public static final String NAME = "Paralyze";
	public static final String ANIMATION_IMAGE_PREFIX = "paralyze_";
	
	/*
	 * Paralyse un ennemi pendant 8 secondes
	 * Empeche un ennemi d'attaquer
	 */
	public static final int DURATION_STOP_NUTRITIONIST_MOVE = 8000;
	
	public Paralyze() {
		super();
		
		setName(NAME);
	}

	@Override
	public void act(Character characterActor, Character characterToAct) {
		Pig pig = (Pig) characterActor;
		Enemy enemy = (Enemy) characterToAct;
		
		ParalyzeAnimation paralyzeAnimation = new ParalyzeAnimation(this, pig, enemy);
		paralyzeAnimation.setDelay(DURATION_STOP_NUTRITIONIST_MOVE);
		paralyzeAnimation.start();
		
		ImageAnimation imageAnimation = new ImageAnimation(enemy, ANIMATION_IMAGE_PREFIX + enemy.getImageName());
		imageAnimation.setDelay(DURATION_STOP_NUTRITIONIST_MOVE);
		imageAnimation.start();
	}
}
