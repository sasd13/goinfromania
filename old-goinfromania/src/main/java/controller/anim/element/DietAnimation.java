package main.java.controller.anim.element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import main.java.controller.anim.AnimationHandler;
import main.java.game.element.character.Enemy;
import main.java.game.element.character.Pig;
import main.java.game.element.power.Diet;
import main.java.util.ImageLoader;

public class DietAnimation extends PowerAnimation {
	
	/*
	 * Empeche le goinfre de manger pendant 8 secondes
	 * Diminue son energie toutes les 2 secondes
	 */		
	public static final int DURATION_STOP_PIG_EAT = 8000;
	public static final int DELAY_DECREASE_PIG_ENERGY = 2000;
	public static final String ANIMATION_IMAGE_PREFIX = "diet_";

	public DietAnimation(Diet diet, Enemy enemy, Pig pig) {
		super(diet, enemy, pig);
		
		setDuration(DURATION_STOP_PIG_EAT);
		setDelay(DELAY_DECREASE_PIG_ENERGY);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		Pig pig = (Pig) getElementToAct();
		BufferedImage image;
		
		if (count == 0) {			
			image = ImageLoader.loadFromPath(ANIMATION_IMAGE_PREFIX + pig.getImageName());
			pig.setImageWithDimension(image);
			
			pig.setGreedy(false);
		} else if (count >= getDuration() / getDelay()) {			
			image = ImageLoader.loadFromPath(pig.getImageName());
			pig.setImageWithDimension(image);
			
			pig.setGreedy(true);
			
			AnimationHandler.stop(this);
		} else {
			pig.setEnergy(pig.getEnergy() - getPower().getPowerValue());
		}
	}
}
