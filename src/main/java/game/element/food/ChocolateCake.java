package main.java.game.element.food;

import java.awt.image.BufferedImage;

import main.java.util.ImageLoader;

public class ChocolateCake extends Cake {

	public static final String NAME = "ChocolateCake";
	public static final String IMAGE_NAME = "cake_chocolate.png";
	public static final int EFFECT_VALUE_INCREASE_PIG_ENERGY = 5*Cake.EFFECT_VALUE_INCREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 5*Cake.SCORE_POINT;
	
	public ChocolateCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(EFFECT_VALUE_INCREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
