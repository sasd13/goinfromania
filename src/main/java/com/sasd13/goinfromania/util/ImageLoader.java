package com.sasd13.goinfromania.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadFromPath(String fileName) {
		BufferedImage bufferedImage = null;
		
		try {
			ClassLoader loader = ImageLoader.class.getClassLoader();
			bufferedImage = ImageIO.read(loader.getResource(fileName));
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
		return bufferedImage;
	}
}
