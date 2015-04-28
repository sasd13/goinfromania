package game.element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadFromPath(String path) {
		BufferedImage bufferedImage = null;
		
		File file = new File(path);
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Error loading file : " + file.getAbsolutePath());
			System.out.println(e.getMessage());
		}
		
		return bufferedImage;
	}
}
