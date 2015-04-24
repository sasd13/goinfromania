package game.element;

import game.Model;
import game.draw.Drawing;
import game.setting.Dimension;
import game.setting.Direction;
import game.setting.Position;

public abstract class Element extends Model {

	private String id;
	private Position position;
	private Dimension dimension;
	private Drawing drawing;
	private boolean movable;
	private Speed speed;
	
	protected Element() {
		super();
		
		setTitle("Element");
		
		this.position = new Position();
		this.dimension = new Dimension();
		this.drawing = null;
		this.movable = false;
		this.speed = new Speed();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
		
		setChanged();
		notifyObservers();
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
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
	
	public Speed getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(Speed speed) {
		this.speed = speed;
		
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
	
	public Position getNextPosition(Direction direction) {
		if(!this.movable) {
			return this.position;
		}
		
		Position nextPosition = new Position();
		
		switch (direction) {
			case LEFT :
				nextPosition.setX(this.position.getX() - this.speed.getValue());
				break;
			case RIGHT :
				nextPosition.setX(this.position.getX() + this.speed.getValue());
				break;
			case UP :
				nextPosition.setY(this.position.getY() + this.speed.getValue());
				break;
			case DOWN :
				nextPosition.setY(this.position.getY() - this.speed.getValue());
				break;
		}
		
		return nextPosition;
	}
	
	public Position move(Direction direction) {
		if(!isMovable()) {
			return this.position;
		}
		
		Position nextPosition = getNextPosition(direction);
		setPosition(nextPosition);
		
		return nextPosition;
	}
}
