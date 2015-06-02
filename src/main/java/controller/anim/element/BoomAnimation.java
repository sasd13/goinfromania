package main.java.controller.anim.element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import main.java.controller.ArenaController;
import main.java.controller.anim.Animation;
import main.java.controller.anim.AnimationHandler;
import main.java.game.element.power.Power;
import main.java.util.ImageLoader;

public class BoomAnimation extends Animation {

	public static final String ANIMATION_IMAGE_PREFIX = "boom_";
	public static final int BOOM_DELAY = 700;
	
	private Power power;
	
	public BoomAnimation(Power power) {
		super();
		
		setDelay(BOOM_DELAY);
		
		this.power = power;
	}
	
	public Power getPower() {
		return this.power;
	}
	
	public void setPower(Power power) {
		this.power = power;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {			
			BufferedImage image = ImageLoader.loadFromPath(ANIMATION_IMAGE_PREFIX + this.power.getImageName());
			this.power.setImageWithDimension(image);
		} else {
			ArenaController.removeElement(this.power);
			
			AnimationHandler.finish(this);
		}
	}
}
