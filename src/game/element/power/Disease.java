package game.element.power;

import java.awt.event.ActionEvent;

import game.element.Element;
import game.element.character.Character;
import game.element.character.Enemy;
import game.element.character.Pig;
import gamex.animation.ImageAnimation;
import gamex.animation.PowerAnimation;

public class Disease extends Power {

	public static final String NAME = "Disease";
	public static final String ANIMATION_IMAGE_PREFIX = "disease_";
	
	/* 
	 * Ralentit le goinfre pendant 8 secondes et diminue la vie du goinfre de 20
	 */
	public static final int DURATION_DECREASE_PIG_SPEED = 8000;
	public static final int VALUE_DECREASE_PIG_LIFE = 20;
	
	private class DiseaseAnimation extends PowerAnimation {
		
		public DiseaseAnimation(Enemy enemy, Pig pig) {
			super(enemy, pig);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			
			Pig pig = (Pig) getElementToAct();
			
			if (count == 0) {
				pig.setLife(pig.getLife() - getPowerValue());
				pig.setSpeed(SPEED_LOW);
			} else {
				pig.setSpeed(Element.SPEED_MEDIUM);
				timer.stop();
			}
		}
	}
	
	public Disease() {
		super();
		
		setName(NAME);
		setPowerValue(VALUE_DECREASE_PIG_LIFE);
	}
	
	@Override
	public void act(Character characterActor, Character characterToAct) {
		Enemy enemy = (Enemy) characterActor;
		Pig pig = (Pig) characterToAct;
		
		DiseaseAnimation diseaseAnimation = new DiseaseAnimation(enemy, pig);
		diseaseAnimation.setDelay(DURATION_DECREASE_PIG_SPEED);
		diseaseAnimation.start();
		
		ImageAnimation imageAnimation = new ImageAnimation(pig, ANIMATION_IMAGE_PREFIX);
		imageAnimation.setDelay(DURATION_DECREASE_PIG_SPEED);
		imageAnimation.start();
	}
}
