package game.element.food;

import java.awt.image.BufferedImage;

import util.ElementUtil;
import game.element.character.Pig;

public class Cake extends Food {

	public static final String NAME = "Cake";
	public static final String IMAGE_NAME = "cake_1.png";
	public static final int VALUE_EVOLVE_PIG_ENERGY = 15;
	public static final int SCORE_POINT = 50;
	
	public Cake() {
		super();
		
		setName(NAME);
		setMovable(true);
		setSpeed(SPEED_LOW);
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ElementUtil.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
	
	@Override
	public void act(Pig pig) {
		pig.setEnergy(pig.getEnergy() + getEffectValue());
		pig.cakeEaten();
		
		super.act(pig);
	}
}
