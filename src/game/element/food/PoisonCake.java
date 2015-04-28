package game.element.food;

import game.element.ImageLoader;

import java.awt.image.BufferedImage;

public class PoisonCake extends Cake {
	
	public static final String NAME = "PoisonCake";
	public static final String IMAGE_PATH = IMAGE_DIR + "poison_cake.png";
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 0 - Cake.VALUE_EVOLVE_PIG_ENERGY;
	
	public PoisonCake() {
		super();
		
		setName(NAME);
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_PATH);
		setImage(image);
	}
}
