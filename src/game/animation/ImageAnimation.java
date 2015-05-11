package game.animation;

import game.element.Element;

import java.awt.image.BufferedImage;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
		BufferedImage originalImage = ElementUtil.loadFromPath(elementToAct.getImageName());
		BufferedImage image = ElementUtil.loadFromPath(this.imageName + elementToAct.getImageName());
		
		elementToAct.setImageWithDimension(image);
		
        RoundController roundController = GameController.getInstance().getRoundController();
        roundController.updateArena();
        
        this.scheduler = Executors.newScheduledThreadPool(2);
        endAnimation(elementToAct, originalImage);
	}
	
	private synchronized void endAnimation(final Element element, final BufferedImage image) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				element.setImage(image);
				RoundController roundController = GameController.getInstance().getRoundController();
		        roundController.updateArena();
		        scheduler.shutdown();
			}
		};
		
		this.scheduler.schedule(runnable, getDuration(), TimeUnit.MILLISECONDS);
	}
}
