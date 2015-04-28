package game.element.food;

import java.awt.image.BufferedImage;

import game.element.ImageLoader;
import game.element.character.Pig;

public class Cake extends Food {

	public static final String NAME = "Cake";
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 15;
	public static final String IMAGE_PATH = IMAGE_DIR + "cake.png";
	
	public Cake() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(SPEED_LOW);
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_PATH);
		setImage(image);
	}
	
	@Override
	public void act(Pig pig) {
		pig.setEnergy(pig.getEnergy() + getEffectValue());
		pig.cakeEaten();
	}
}
