package gamex.animation;

import game.element.Element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import util.ImageLoader;
import controller.ArenaController;

public class ImageAnimation extends Animation {

	private Element element;
	private BufferedImage originalImage;
	private String prefix;
	
	public ImageAnimation(Element element, String prefix) {
		super();
		
		this.element = element;
		this.originalImage = ImageLoader.loadFromPath(this.element.getImageName());
		this.prefix = prefix;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			BufferedImage image = ImageLoader.loadFromPath(this.prefix + this.element.getImageName());
			this.element.setImageWithDimension(image);
		} else {
			this.element.setImageWithDimension(this.originalImage);
			this.timer.stop();
		}
		
		ArenaController.repaintArena();
	}
}
