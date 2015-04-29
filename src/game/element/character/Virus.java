package game.element.character;

import java.awt.image.BufferedImage;

import game.element.ImageLoader;
import game.element.power.Disease;

public class Virus extends Enemy {

	public static final String NAME = "Virus";
	public static final String IMAGE_NAME = "virus.png";
	public static final int LIFE_VALUE = 100;
	public static final int SCORE_POINT = 1000;
	
	public Virus() {
		super();
		
		setName(NAME);
		setLife(LIFE_VALUE);
		setPower(new Disease());
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImage(image);
	}
}
