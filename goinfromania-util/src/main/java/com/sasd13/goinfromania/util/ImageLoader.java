package com.sasd13.goinfromania.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadFromPath(String fileName) {
		BufferedImage bufferedImage = null;

		try {
			URL url = ImageLoader.class.getClassLoader().getResource(fileName);
			bufferedImage = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bufferedImage;
	}
}
