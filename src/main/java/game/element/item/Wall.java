package main.java.game.element.item;

import java.awt.image.BufferedImage;

import main.java.game.element.Element;
import main.java.util.ImageLoader;

public class Wall extends Element {
	
	public static final String NAME = "Wall";
	public static final String IMAGE_NAME = "wall.png";
	
	public Wall() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setSpeed(0);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
