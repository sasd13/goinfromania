package com.sasd13.goinfromania.view.arena.image;

import java.awt.image.BufferedImage;

import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.util.ImageLoader;
import com.sasd13.goinfromania.view.ImageConstants;

public class PigDrawable implements IDrawable {

	private static BufferedImage imagePig = ImageLoader.loadFromPath(ImageConstants.PIG);
	private static BufferedImage imagePigDiet = ImageLoader.loadFromPath(ImageConstants.PIG_DIET);
	private static BufferedImage imagePigDisease = ImageLoader.loadFromPath(ImageConstants.PIG_DISEASE);
	private static BufferedImage imagePigHit = ImageLoader.loadFromPath(ImageConstants.PIG_HIT);

	@Override
	public BufferedImage draw(IElement element) {
		Pig pig = (Pig) element;

		switch (pig.getState()) {
			case DIET:
				return imagePigDiet;
			case DISEASE:
				return imagePigDisease;
			case HIT:
				return imagePigHit;
			default:
				return imagePig;
		}
	}
}
