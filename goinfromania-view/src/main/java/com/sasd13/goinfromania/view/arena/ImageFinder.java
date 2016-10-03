package com.sasd13.goinfromania.view.arena;

import java.awt.image.BufferedImage;

import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.util.ImageLoader;
import com.sasd13.goinfromania.view.ImageConstants;

public class ImageFinder {

	private static BufferedImage imagePig;

	private ImageFinder() {
	}

	public static final BufferedImage find(IElement element) {
		if (element instanceof Pig) {
			if (imagePig == null) {
				imagePig = ImageLoader.loadFromPath(ImageConstants.PIG);
			}
			
			return imagePig;
		} else {
			return null;
		}
	}
}
