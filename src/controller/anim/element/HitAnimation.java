package controller.anim.element;

import game.element.Element;

public class HitAnimation extends ImageAnimation {

	public static final int DELAY_HIT = 100;
	public static final String ANIMATION_IMAGE_PREFIX = "hit_";
	
	public HitAnimation(Element element) {
		super(ANIMATION_IMAGE_PREFIX + element.getImageName(), element);
		
		setDelay(DELAY_HIT);
	}
}
