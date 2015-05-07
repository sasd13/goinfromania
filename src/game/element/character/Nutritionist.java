package game.element.character;

import java.awt.image.BufferedImage;

import util.ElementUtil;
import game.element.power.Diet;

public class Nutritionist extends Enemy {

	public static final String NAME = "Nutritionist";
	public static final String IMAGE_NAME = "nutritionist.png";
	public static final int LIFE_VALUE = 50;
	public static final int SCORE_POINT = 200;
	
	public Nutritionist() {
		super();
		
		setName(NAME);
		setLife(LIFE_VALUE);
		setPower(new Diet());
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ElementUtil.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
	
	public void pursuePig(Pig pig) {
		//TODO Implementation
		
	}
}
