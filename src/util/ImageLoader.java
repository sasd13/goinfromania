package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

import main.Main;

public class ImageLoader {
	
	private static final String IMAGE_DIR = "/";

	public static BufferedImage loadFromPath(String fileName) {
		BufferedImage bufferedImage = null;
		
		URL url = Main.class.getResource(IMAGE_DIR + fileName);
		
		try {
			File file = new File(url.toURI());
			bufferedImage = ImageIO.read(file);
		} catch (URISyntaxException | IOException e ) {
			e.printStackTrace();
		}
		
		return bufferedImage;
	}
}
