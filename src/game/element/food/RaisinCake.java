package game.element.food;

import java.awt.image.BufferedImage;

import util.ImageLoader;

public class RaisinCake extends Cake {

	public static final String NAME = "RaisinCake";
	public static final String IMAGE_NAME = "cake_raisin.png";
	public static final int EFFECT_VALUE_INCREASE_PIG_ENERGY = 1*Cake.EFFECT_VALUE_INCREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 1*Cake.SCORE_POINT;
	
	public RaisinCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(EFFECT_VALUE_INCREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
