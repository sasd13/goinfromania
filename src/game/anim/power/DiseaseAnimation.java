package game.anim.power;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Disease;
import game.util.ImageLoader;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

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
			pig.setLife(pig.getLife() - getPower().getPowerValue());
			pig.setSpeed(Pig.SPEED_LOW);
			
			image = ImageLoader.loadFromPath(ANIMATION_IMAGE_PREFIX + pig.getImageName());
			pig.setImageWithDimension(image);
		} else {
			timer.stop();
			
			image = ImageLoader.loadFromPath(pig.getImageName());
			pig.setImageWithDimension(image);
			
			pig.setSpeed(Pig.SPEED_MEDIUM);
		}
	}
}
