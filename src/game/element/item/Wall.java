package game.element.item;

import java.awt.image.BufferedImage;

import util.ElementUtil;
import game.element.Element;

public class Wall extends Element {
	
	public static final String NAME = "Wall";
	public static final String IMAGE_NAME = "wall.png";
	
	public Wall() {
		super();
		
		setName(NAME);
		
		BufferedImage image = ElementUtil.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
