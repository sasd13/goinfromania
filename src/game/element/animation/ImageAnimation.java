package game.element.animation;

import game.element.Element;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import util.ElementUtil;
import controller.GameController;
import controller.RoundController;

public class ImageAnimation extends Animation {

	public static final int DELAY = 100;
	
	private String imageName;
	
	public ImageAnimation() {
		super();
		
		this.imageName = null;
	}
	
	public String getImageName() {
		return this.imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Override
	public void start(Element elementActor, Element elementToAct) {
		this.timer = new Timer();
		
		BufferedImage originalImage = elementToAct.getImage();
		BufferedImage image = ElementUtil.loadFromPath(this.imageName + elementToAct.getImageName());
		
		elementToAct.setImageWithDimension(image);
		
        RoundController roundController = GameController.getInstance().getRoundController();
        roundController.updateArena();
        
        endAnimation(elementToAct, originalImage);
	}
	
	private synchronized void endAnimation(final Element element, final BufferedImage image) {
		this.timer.cancel();
		this.timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				element.setImage(image);
				RoundController roundController = GameController.getInstance().getRoundController();
		        roundController.updateArena();
			}
		};
		
		this.timer.schedule(task, getDuration());
	}
}
