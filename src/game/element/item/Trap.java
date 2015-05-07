package game.element.item;

import java.awt.image.BufferedImage;

import util.ElementUtil;
import game.element.Element;

public class Trap extends Element {

	public static final String NAME = "Trap";
	public static final String IMAGE_NAME = "trap.png";
	
	public Trap() {
		super();
		
		setName(NAME);
		
		BufferedImage image = ElementUtil.loadFromPath(IMAGE_NAME);
		setImage(image);
	}
}
