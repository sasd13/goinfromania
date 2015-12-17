package main.java.game.element.food;

import java.awt.image.BufferedImage;

import main.java.util.ImageLoader;

public class StrawberryCake extends Cake {

	public static final String NAME = "StrawberryCake";
	public static final String IMAGE_NAME = "cake_strawberry.png";
	public static final int EFFECT_VALUE_INCREASE_PIG_LIFE = 20;
	public static final int SCORE_POINT = 20*Cake.SCORE_POINT;
	
	public StrawberryCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(EFFECT_VALUE_INCREASE_PIG_LIFE);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
