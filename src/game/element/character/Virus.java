package game.element.character;

import java.awt.image.BufferedImage;

import game.element.ImageLoader;
import game.element.power.Disease;
import game.element.power.ListPowers;

public class Virus extends Character {

	public static final String NAME = "Virus";
	public static final String IMAGE_PATH = IMAGE_DIR + "virus.png";
	
	public Virus() {
		super();
		
		setName(NAME);
		setPowerful(true);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_PATH);
		setImage(image);
		
		ListPowers listPowers = new ListPowers();
		listPowers.add(new Disease());
		setListPowers(listPowers);
	}
}
