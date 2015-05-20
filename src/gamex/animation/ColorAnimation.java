package gamex.animation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import controller.ArenaController;

public class ColorAnimation extends Animation {
	
	private Color color;
	
	private BufferedImage image;
	private Raster raster;
	
	public ColorAnimation(BufferedImage image) {
		super();
		
		this.color = Color.RED;
		
		this.image = image;
		this.raster = this.image.getData();
	}
	
	public ColorAnimation(BufferedImage image, Color color) {
		this(image);
		
		setColor(color);
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		
		if (count == 0) {
			int width = this.image.getWidth();
		    int height = this.image.getHeight();
	        for (int xx=0; xx<width; xx++) {
	            for (int yy=0; yy<height; yy++) {
	            	Color originalColor = new Color(image.getRGB(xx, yy));
	            	if (!(originalColor.equals(Color.WHITE) && originalColor.getAlpha() == 255)) {
	            		this.image.setRGB(xx, yy, getColor().getRGB());
	            	}
	            }
	        }
		} else {
			this.image.setData(this.raster);
	        timer.stop();
		}
		
		ArenaController.repaintArena();
	}
}
