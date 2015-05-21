package game.element.food;

import game.util.ImageLoader;

import java.awt.image.BufferedImage;

public class KiwiCake extends PoisonCake {

	public static final String NAME = "KiwiCake";
	public static final String IMAGE_NAME = "cake_kiwi.png";
	public static final int VALUE_DECREASE_PIG_ENERGY = 2*PoisonCake.VALUE_DECREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 2*PoisonCake.SCORE_POINT;
	
	public KiwiCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
