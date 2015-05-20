package util.animation;

import game.element.Element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import util.ImageLoader;
import controller.ArenaController;

public class ImageAnimation extends Animation {

	private Element element;
	private BufferedImage originalImage;
	private String imagePrefix;
	
	public ImageAnimation(Element element, String imagePrefix) {
		super();
		
		this.element = element;
		this.originalImage = ImageLoader.loadFromPath(this.element.getImageName());
		this.imagePrefix = imagePrefix;
	}
	
	public String getImagePrefix() {
		return this.imagePrefix;
	}
	
	public void setImagePrefix(String imagePrefix) {
		this.imagePrefix = imagePrefix;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			BufferedImage image = ImageLoader.loadFromPath(this.imagePrefix + this.element.getImageName());
			this.element.setImageWithDimension(image);
		} else {
			this.element.setImageWithDimension(this.originalImage);
			timer.stop();
		}
		
		ArenaController.repaintArena();
	}
}
