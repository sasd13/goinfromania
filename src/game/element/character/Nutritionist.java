package game.element.character;

import java.awt.image.BufferedImage;

import game.element.ImageLoader;
import game.element.power.Diet;
import game.element.power.ListPowers;

public class Nutritionist extends Character {

	public static final String NAME = "Nutritionist";
	public static final String IMAGE_PATH = IMAGE_DIR + "nutritionist.png";
	
	public Nutritionist() {
		super();
		
		setName(NAME);
		setPowerful(true);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_PATH);
		setImage(image);
		
		ListPowers listPowers = new ListPowers();
		listPowers.add(new Diet());
		setListPowers(listPowers);
	}
}
