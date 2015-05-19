package gamex.animation;

import game.element.Element;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import controller.ArenaController;

public class ColorAnimation extends Animation {
	
	private Color color;
	
	public ColorAnimation() {
		super();
		
		this.color = Color.RED;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void start(Element elementActor, Element elementToAct) {
		BufferedImage image = elementToAct.getImage();
		Raster raster = image.getData();
		
		int width = image.getWidth();
	    int height = image.getHeight();
        for (int xx=0; xx<width; xx++) {
            for (int yy=0; yy<height; yy++) {
            	Color originalColor = new Color(image.getRGB(xx, yy));
            	if (!(originalColor.equals(Color.WHITE) && originalColor.getAlpha() == 255)) {
            		image.setRGB(xx, yy, this.color.getRGB());
            	}
            }
        }
        
        ArenaController.repaintArena();
        
        this.scheduler = Executors.newScheduledThreadPool(2);
        endHit(image, raster);
	}
	
	private synchronized void endHit(final BufferedImage bufferedImage, final Raster raster) {
		Runnable runable = new Runnable() {
			
			@Override
			public void run() {
				bufferedImage.setData(raster);
				ArenaController.repaintArena();
		        scheduler.shutdown();
			}
		};
		
		this.scheduler.schedule(runable, getDuration(), TimeUnit.MILLISECONDS);
	}
}
