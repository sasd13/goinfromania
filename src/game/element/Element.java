package game.element;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Observable;

import game.element.draw.Drawing;
import game.setting.Direction;

public abstract class Element extends Observable {
	
	public static final int POSITION_X_MIN = 0;
	public static final int POSITION_X_MAX = 800; //Ne pas modifier
	
	public static final int POSITION_Y_MIN = 0;
	public static final int POSITION_Y_MAX = -500; //Ne pas modifier
	
	public static final int SPEED_MIN = 0;
	public static final int SPEED_MAX = 50;
	
	public static final int SPEED_LOW = 10;
	public static final int SPEED_MEDIUM = 25;
	public static final int SPEED_HIGH = 40;

	private static int countElement;
	private String id;
	private String name;
	private boolean visible;
	private Point position;
	private Dimension dimension;
	private Drawing drawing;
	private boolean movable;
	private int speed;
	
	protected Element() {
		super();
		
		countElement++;
		this.id = "id-element-" + countElement;
		this.name = null;
		this.visible = true;
		this.position = new Point();
		this.dimension = new Dimension();
		this.drawing = null;
		this.movable = false;
		this.speed = SPEED_MIN;
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
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
		
		setChanged();
		notifyObservers();
	}
	
	public Point getPosition() {
		return this.position;
	}
	
	private void setPosition(Point position) {
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
	
	public Drawing getDrawing() {
		return this.drawing;
	}
	
	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
		
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
	
	public Point getNextPosition(Direction direction) {
		if (!this.movable) {
			return this.position;
		}
		
		Point nextPosition = new Point();
		
		switch (direction) {
			case LEFT :
				nextPosition.x = this.position.x - this.speed;
				break;
			case RIGHT :
				nextPosition.x = this.position.x + this.speed;
				break;
			case UP :
				nextPosition.y = this.position.y + this.speed;
				break;
			case DOWN :
				nextPosition.y = this.position.y - this.speed;
				break;
		}
		
		if (nextPosition.x <= POSITION_X_MIN) {
			nextPosition.x = POSITION_X_MIN;
		} else if (nextPosition.x >= POSITION_X_MAX) {
			nextPosition.x = POSITION_X_MAX;
		}
		
		if (nextPosition.y >= POSITION_Y_MIN) {
			nextPosition.y = POSITION_Y_MIN;
		} else if (nextPosition.y <= POSITION_Y_MAX) {
			nextPosition.y = POSITION_Y_MAX;
		}
		
		return nextPosition;
	}
	
	public Point move(Direction direction) {
		Point nextPosition = getNextPosition(direction);
		setPosition(nextPosition);
		
		return nextPosition;
	}
}
