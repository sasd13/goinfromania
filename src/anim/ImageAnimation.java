package anim;

import game.element.Element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import util.ImageLoader;
import controller.ArenaController;

public class ImageAnimation extends Animation {

	private Element element;
	private BufferedImage originalImage;
	private String imageName;
	
	public ImageAnimation(Element element, String imageName) {
		super();
		
		this.element = element;
		this.originalImage = ImageLoader.loadFromPath(this.element.getImageName());
		this.imageName = imageName;
	}
	
	public String getImageName() {
		return this.imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			BufferedImage image = ImageLoader.loadFromPath(this.imageName);
			this.element.setImageWithDimension(image);
		} else {
			this.element.setImageWithDimension(this.originalImage);
			timer.stop();
		}
		
		ArenaController.repaintArena();
	}
}
