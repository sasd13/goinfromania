package game.element.food;

import java.awt.image.BufferedImage;

import util.ImageLoader;

public class CherryCake extends PoisonCake {

	public static final String NAME = "CherryPoisonCake";
	public static final String IMAGE_NAME = "cake_cherry.png";
	public static final int EFFECT_VALUE_DECREASE_PIG_ENERGY = 2*PoisonCake.EFFECT_VALUE_DECREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 2*PoisonCake.SCORE_POINT;
	
	public CherryCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(EFFECT_VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
