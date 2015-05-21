package game.anim;

import game.element.Element;
import game.util.ImageLoader;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import controller.ArenaController;

public class ImageAnimation extends Animation {

	private String imageName;
	private Element elementToAct;
	private BufferedImage originalImage;
	
	public ImageAnimation(String imageName, Element elementToAct) {
		super();
		
		this.imageName = imageName;
		this.elementToAct = elementToAct;
		this.originalImage = ImageLoader.loadFromPath(this.elementToAct.getImageName());
	}
	
	public String getImageName() {
		return this.imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public Element getElementToAct() {
		return this.elementToAct;
	}
	
	public void setElementToAct(Element elementToAct) {
		this.elementToAct = elementToAct;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			BufferedImage image = ImageLoader.loadFromPath(this.imageName);
			this.elementToAct.setImageWithDimension(image);
		} else {
			this.elementToAct.setImageWithDimension(this.originalImage);
			timer.stop();
		}
		
		ArenaController.repaintArena();
	}
}
