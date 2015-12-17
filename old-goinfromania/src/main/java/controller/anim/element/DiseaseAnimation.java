package main.java.controller.anim.element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import main.java.controller.anim.AnimationHandler;
import main.java.game.element.character.Enemy;
import main.java.game.element.character.Pig;
import main.java.game.element.power.Disease;
import main.java.util.ImageLoader;

public class DiseaseAnimation extends PowerAnimation {
	
	/* 
	 * Diminue la vie du goinfre et le ralentit le goinfre pendant 8 secondes
	 */
	public static final int DURATION_DECREASE_PIG_SPEED = 8000;
	public static final String ANIMATION_IMAGE_PREFIX = "disease_";
	
	public DiseaseAnimation(Disease disease, Enemy enemy, Pig pig) {
		super(disease, enemy, pig);
		
		setDelay(DURATION_DECREASE_PIG_SPEED);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		Pig pig = (Pig) getElementToAct();
		BufferedImage image;
		
		if (count == 0) {
			image = ImageLoader.loadFromPath(ANIMATION_IMAGE_PREFIX + pig.getImageName());
			pig.setImageWithDimension(image);
			
			pig.setLife(pig.getLife() - getPower().getPowerValue());
			pig.setSpeed(Pig.SPEED_LOW);
		} else {
			image = ImageLoader.loadFromPath(pig.getImageName());
			pig.setImageWithDimension(image);
			
			pig.setSpeed(Pig.SPEED_MEDIUM);
			
			AnimationHandler.stop(this);
		}
	}
}
