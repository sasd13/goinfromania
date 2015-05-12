package game.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private static final String IMAGE_DIR = "img/";

	public static BufferedImage loadFromPath(String fileName) {
		BufferedImage bufferedImage = null;
		
		File file = new File(IMAGE_DIR + fileName);
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Error loading file : " + file.getAbsolutePath());
			System.out.println(e.getMessage());
		}
		
		return bufferedImage;
	}
}
