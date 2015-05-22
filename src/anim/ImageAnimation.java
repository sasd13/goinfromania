package anim;

import game.element.Element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import util.ImageLoader;
import controller.ArenaController;

public class ImageAnimation extends Animation {

	private String imageName;
	private Element elementToAct;
	
	public ImageAnimation(String imageName, Element elementToAct) {
		super();
		
		this.imageName = imageName;
		this.elementToAct = elementToAct;
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
		
		BufferedImage image;
		
		if (count == 0) {
			image = ImageLoader.loadFromPath(this.imageName);
			this.elementToAct.setImageWithDimension(image);
		} else {
			stop();
			
			image = ImageLoader.loadFromPath(this.elementToAct.getImageName());
			this.elementToAct.setImageWithDimension(image);
		}
		
		ArenaController.repaintArena();
	}
}
