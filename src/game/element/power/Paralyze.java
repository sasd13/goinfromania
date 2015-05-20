package game.element.power;

import java.awt.event.ActionEvent;

import util.animation.ImageAnimation;
import util.animation.PowerAnimation;
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
	
	private class ParalyzeAnimation extends PowerAnimation {
		
		public ParalyzeAnimation(Pig pig, Enemy enemy) {
			super(pig, enemy);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			
			Enemy enemy = (Enemy) getElementToAct();
			
			if (count == 0) {
				enemy.setMovable(false);
				enemy.setPowerful(false);
			} else {
				enemy.setMovable(true);
				enemy.setPowerful(true);
				timer.stop();
			}
		}
	}
	
	public Paralyze() {
		super();
		
		setName(NAME);
	}

	@Override
	public void act(Character characterActor, Character characterToAct) {
		Pig pig = (Pig) characterActor;
		Enemy enemy = (Enemy) characterToAct;
		
		ParalyzeAnimation paralyzeAnimation = new ParalyzeAnimation(pig, enemy);
		paralyzeAnimation.setDelay(DURATION_STOP_NUTRITIONIST_MOVE);
		paralyzeAnimation.start();
		
		ImageAnimation imageAnimation = new ImageAnimation(enemy, ANIMATION_IMAGE_PREFIX + enemy.getImageName());
		imageAnimation.setDelay(DURATION_STOP_NUTRITIONIST_MOVE);
		imageAnimation.start();
	}
}
