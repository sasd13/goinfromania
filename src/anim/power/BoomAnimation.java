package anim.power;

import game.element.power.Power;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import util.ImageLoader;
import anim.Animation;
import controller.ArenaController;

public class BoomAnimation extends Animation {

	public static final String ANIMATION_IMAGE_PREFIX = "boom_";
	public static final int BOOM_DELAY = 1000;
	
	private Power power;
	
	public BoomAnimation(Power power) {
		super();
		
		setDelay(BOOM_DELAY);
		
		this.power = power;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {			
			BufferedImage image = ImageLoader.loadFromPath(ANIMATION_IMAGE_PREFIX + this.power.getImageName());
			this.power.setImageWithDimension(image);
		} else {
			timer.stop();
			
			ArenaController.removeElement(this.power);
		}
	}
}
