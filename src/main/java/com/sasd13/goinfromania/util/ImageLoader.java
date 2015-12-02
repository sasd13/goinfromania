package com.sasd13.goinfromania.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private static final String IMAGE_DIR = "main/res/";

	public static BufferedImage loadFromPath(String fileName) {
		BufferedImage bufferedImage = null;
		
		try {
			bufferedImage = ImageIO.read(ClassLoader.getSystemResource(IMAGE_DIR + fileName));
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
		return bufferedImage;
	}
}
