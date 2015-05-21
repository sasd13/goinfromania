package game.anim.power;

import game.anim.ImageAnimation;
import game.element.Element;

public class HitAnimation extends ImageAnimation {

	public static final String ANIMATION_IMAGE_PREFIX = "hit_";
	
	public HitAnimation(Element element) {
		super(ANIMATION_IMAGE_PREFIX + element.getImageName(), element);
	}
}
