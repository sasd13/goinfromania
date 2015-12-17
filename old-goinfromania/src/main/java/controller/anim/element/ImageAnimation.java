package main.java.controller.anim.element;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import main.java.controller.ArenaController;
import main.java.controller.anim.Animation;
import main.java.controller.anim.AnimationHandler;
import main.java.game.element.Element;
import main.java.util.ImageLoader;

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
			image = ImageLoader.loadFromPath(this.elementToAct.getImageName());
			this.elementToAct.setImageWithDimension(image);
			
			AnimationHandler.finish(this);
		}
		
		ArenaController.repaintArena();
	}
}
