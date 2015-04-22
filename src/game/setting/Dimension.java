package game.setting;

import game.Model;

public class Dimension extends Model {
	
	public static final int FRAME_SMALL = 320;
	public static final int FRAME_MEDIUM = 480;
	public static final int FRAME_LARGE = 640;
	
	public static final int PANEL_SMALL = 320;
	public static final int PANEL_MEDIUM = 480;
	public static final int PANEL_LARGE = 640;
	
	public static final int BUTTON_WIDTH = 74;
	public static final int BUTTON_HEIGHT = 26;

	private int width;
	private int height;
	
	public Dimension() {
		super();
		
		setTitle("Dimension");
		
		this.width = 0;
		this.height = 0;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
		
		notifyObservers();
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
		
		notifyObservers();
	}
}
