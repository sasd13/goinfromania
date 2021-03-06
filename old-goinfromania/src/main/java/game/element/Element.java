package main.java.game.element;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Observable;

import main.java.util.ElementUtil;
import main.java.view.DimensionConstants;

public abstract class Element extends Observable {
	
	public static final int POSITION_X_MIN = 0;
	public static final int POSITION_X_MAX = DimensionConstants.ARENA_WIDTH;
	public static final int POSITION_Y_MIN = 0;
	public static final int POSITION_Y_MAX = DimensionConstants.ARENA_HEIGHT;
	
	public static final int SPEED_DEFAULT = 1;

	private static int countElement;
	private String id;
	private String name;
	private Point position;
	private Dimension dimension;
	private String imageName;
	private BufferedImage image;
	private boolean movable;
	private int speed;
	
	protected Element() {
		super();
		
		countElement++;
		this.id = "id-element-" + countElement;
		this.name = null;
		this.position = new Point();
		this.dimension = new Dimension();
		this.imageName = null;
		this.image = null;
		this.movable = false;
		this.speed = SPEED_DEFAULT;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		
		setChanged();
		notifyObservers();
	}
	
	public Point getPosition() {
		return this.position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
		
		setChanged();
		notifyObservers();
	}
	
	public Dimension getDimension() {
		return this.dimension;
	}
	
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
		
		setChanged();
		notifyObservers();
	}
	
	public String getImageName() {
		return this.imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
		
		setChanged();
		notifyObservers();
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
		
		setChanged();
		notifyObservers();
	}
	
	public boolean isMovable() {
		return this.movable;
	}
	
	public void setMovable(boolean movable) {
		this.movable = movable;
		
		setChanged();
		notifyObservers();
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
		
		setChanged();
		notifyObservers();
	}
	
	public Dimension setImageWithDimension(BufferedImage image) {
		Dimension dimension = null;
		
		setImage(image);
		setDimension(new Dimension(this.image.getWidth(), this.image.getHeight()));
		
		return dimension;
	}
	
	public Point getNextPosition(Direction direction) {
		Point nextPosition = new Point(this.position.x, this.position.y);
		
		switch (direction) {
			case NORTH :
				nextPosition.y = this.position.y - this.speed;
				break;
			case SOUTH :
				nextPosition.y = this.position.y + this.speed;
				break;
			case WEST :
				nextPosition.x = this.position.x - this.speed;
				break;
			case EAST :
				nextPosition.x = this.position.x + this.speed;
				break;
		}
		
		nextPosition = ElementUtil.cropping(nextPosition, this.dimension); //Recadrage
		
		return nextPosition;
	}
}
