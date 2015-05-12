package game.element.food;

import game.util.ImageLoader;

import java.awt.image.BufferedImage;

public class PoisonCake extends Cake {
	
	public static final String NAME = "PoisonCake";
	public static final String IMAGE_NAME = "cake_2.png";
	public static final int SCORE_POINT = 0 - Cake.SCORE_POINT;
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 0 - Cake.VALUE_EVOLVE_PIG_ENERGY;
	
	public PoisonCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
