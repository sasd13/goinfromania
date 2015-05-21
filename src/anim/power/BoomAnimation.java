package anim.power;

import game.element.Element;
import game.element.ListElements;
import game.element.power.Power;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import anim.Animation;
import util.ImageLoader;
import controller.ArenaController;

public class BoomAnimation extends Animation {

	public static final int BOOM_DELAY = 1000;
	
	private Element elementToAct;
	private Power power;
	private String imageName;
	private ListElements listElements;
	
	public BoomAnimation(Element elementToAct, Power power, String imageName, ListElements listElements) {
		super();
		
		setDelay(BOOM_DELAY);
		
		this.elementToAct = elementToAct;
		this.power = power;
		this.imageName = imageName;
		this.listElements = listElements;
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
			this.power.setImageWithDimension(image);
			this.power.setMovable(false);
			this.listElements.remove(this.elementToAct);
		} else {
			this.listElements.remove(this.power);
			timer.stop();
		}
	}
}
