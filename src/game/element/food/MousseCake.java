package game.element.food;

import java.awt.image.BufferedImage;

import util.ImageLoader;

public class MousseCake extends PoisonCake {
	
	public static final String NAME = "MousseCake";
	public static final String IMAGE_NAME = "cake_mousse.png";
	public static final int VALUE_DECREASE_PIG_ENERGY = 1*PoisonCake.VALUE_DECREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 1*PoisonCake.SCORE_POINT;
	
	public MousseCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(VALUE_DECREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
