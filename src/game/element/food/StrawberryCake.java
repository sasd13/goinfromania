package game.element.food;

import java.awt.image.BufferedImage;

import util.ImageLoader;

public class StrawberryCake extends Cake {

	public static final String NAME = "StrawberryCake";
	public static final String IMAGE_NAME = "cake_strawberry.png";
	public static final int VALUE_INCREASE_PIG_ENERGY = 20*Cake.VALUE_INCREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 20*Cake.SCORE_POINT;
	
	public StrawberryCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(VALUE_INCREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
