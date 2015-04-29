package game.element.item;

import java.awt.image.BufferedImage;

import game.element.Element;
import game.element.ImageLoader;

public class Trap extends Element {

	public static final String NAME = "Trap";
	public static final String IMAGE_NAME = "trap.png";
	
	public Trap() {
		super();
		
		setName(NAME);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImage(image);
	}
}
