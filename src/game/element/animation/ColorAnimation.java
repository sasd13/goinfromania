package game.element.animation;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Timer;
import java.util.TimerTask;

import controller.GameController;
import controller.RoundController;

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
	public void start() {
		this.timer = new Timer();
		
		BufferedImage image = getElementToAct().getImage();
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
        
        RoundController roundController = GameController.getInstance().getRoundController();
        roundController.updateArena();
        
        endHit(image, raster);
	}
	
	private synchronized void endHit(final BufferedImage bufferedImage, final Raster raster) {
		this.timer.cancel();
		this.timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				bufferedImage.setData(raster);
				RoundController roundController = GameController.getInstance().getRoundController();
		        roundController.updateArena();
			}
		};
		
		this.timer.schedule(task, getDelay());
	}
}
