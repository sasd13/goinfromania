package game.element;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Observable;

import game.draw.Drawing;
import game.setting.Direction;

public abstract class Element extends Observable {

	private static int numberElement;
	private String id;
	private String title;
	private boolean visible;
	private Point position;
	private Dimension dimension;
	private Drawing drawing;
	private boolean movable;
	private Speed speed;
	
	protected Element() {
		super();
		
		numberElement++;
		this.id = "id-element"+numberElement;
		this.title = null;
		this.visible = true;
		this.position = new Point();
		this.dimension = new Dimension();
		this.drawing = null;
		this.movable = false;
		this.speed = null;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
		
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
	
	private void setDimension(Dimension dimension) {
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
	
	public Speed getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(Speed speed) {
		this.speed = speed;
		
		setChanged();
		notifyObservers();
	}
	
	public Point getNextPosition(Direction direction) {
		if(!this.movable) {
			return this.position;
		}
		
		Point nextPosition = new Point();
		
		switch (direction) {
			case LEFT :
				nextPosition.x = this.position.x - this.speed.getValue();
				break;
			case RIGHT :
				nextPosition.x = this.position.x + this.speed.getValue();
				break;
			case UP :
				nextPosition.y = this.position.y + this.speed.getValue();
				break;
			case DOWN :
				nextPosition.y = this.position.y - this.speed.getValue();
				break;
		}
		
		return nextPosition;
	}
	
	public Point move(Direction direction) {
		if(!this.movable) {
			return this.position;
		}
		
		Point nextPosition = getNextPosition(direction);
		setPosition(nextPosition);
		
		return nextPosition;
	}
}
