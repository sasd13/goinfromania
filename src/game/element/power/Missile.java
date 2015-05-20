package game.element.power;

import java.awt.event.ActionEvent;

import game.element.Element;
import game.element.character.Character;
import game.element.character.Enemy;
import game.element.character.Pig;
import gamex.animation.ImageAnimation;
import gamex.animation.PowerAnimation;

public class Missile extends Power {

	public static final String NAME = "Missile";
	public static final String ANIMATION_IMAGE_PREFIX = "hit_";
	
	/* 
	 * Diminue la vie d'un personnage de 25
	 */	
	public static final int VALUE_DECREASE_CHARACTER_LIFE = 25;
	
	public class MissileAnimation extends PowerAnimation {

		protected MissileAnimation(Element elementActor, Element elementToAct) {
			super(elementActor, elementToAct);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public Missile() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(SPEED_HIGH);
		setPowerValue(VALUE_DECREASE_CHARACTER_LIFE);
		setAfar(true);
	}

	@Override
	public void act(Character characterActor, Character characterToAct) {
		Pig pig = (Pig) characterActor;
		Enemy enemy = (Enemy) characterToAct;
		
		enemy.setLife(enemy.getLife() - getPowerValue());
		
		ImageAnimation imageAnimation = new ImageAnimation(enemy, ANIMATION_IMAGE_PREFIX);
		imageAnimation.start();
	}
}
