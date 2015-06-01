package game.element.food;

import java.awt.image.BufferedImage;

import util.ImageLoader;

public class KiwiCake extends PoisonCake {

	public static final String NAME = "KiwiCake";
	public static final String IMAGE_NAME = "cake_kiwi.png";
	
	public KiwiCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(EFFECT_VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
