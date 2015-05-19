package gamex.animation;

import game.element.Element;

import java.awt.image.BufferedImage;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.ImageLoader;
import controller.ArenaController;

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
		BufferedImage originalImage = ImageLoader.loadFromPath(elementToAct.getImageName());
		BufferedImage image = ImageLoader.loadFromPath(this.imageName + elementToAct.getImageName());
		
		elementToAct.setImageWithDimension(image);
		
		ArenaController.repaintArena();
        
        this.scheduler = Executors.newScheduledThreadPool(2);
        endAnimation(elementToAct, originalImage);
	}
	
	private synchronized void endAnimation(final Element element, final BufferedImage image) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				element.setImage(image);
				ArenaController.repaintArena();
		        scheduler.shutdown();
			}
		};
		
		this.scheduler.schedule(runnable, getDuration(), TimeUnit.MILLISECONDS);
	}
}
