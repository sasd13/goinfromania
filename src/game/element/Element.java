package game.element;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Observable;

import util.MathUtil;
import view.DimensionConstants;
import game.setting.Direction;

public abstract class Element extends Observable {
	
	public static final int POSITION_X_MIN = 0;
	public static final int POSITION_X_MAX = DimensionConstants.GRID_WIDTH;
	
	public static final int POSITION_Y_MIN = 0;
	public static final int POSITION_Y_MAX = DimensionConstants.GRID_HEIGHT;
	
	public static final int SPEED_MIN = 0;
	public static final int SPEED_MAX = 100;
	
	public static final int SPEED_LOW = 20;
	public static final int SPEED_MEDIUM = 50;
	public static final int SPEED_HIGH = 80;

	private static int countElement;
	private String id;
	private String name;
	private boolean visible;
	private Point position;
	private Dimension dimension;
	private BufferedImage image;
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
		this.image = null;
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
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
		
		setChanged();
		notifyObservers();
		
		Dimension dimension = new Dimension(this.image.getWidth(), this.image.getHeight());
		setDimension(dimension);
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
		if (speed < SPEED_MIN) {
			this.speed = SPEED_MIN;
		} else if (speed > SPEED_MAX) {
			this.speed = SPEED_MAX;
		} else {
			this.speed = speed;
		}
		
		setChanged();
		notifyObservers();
	}
	
	public Point move(Direction direction) {
		if (!this.movable) {
			return this.position;
		}
		
		Point nextPosition = getNextPosition(direction);
		setPosition(nextPosition);
		
		return nextPosition;
	}
	
	public Point getNextPosition(Direction direction) {
		Point nextPosition = new Point(this.position.x, this.position.y);
		
		switch (direction) {
			case LEFT :
				nextPosition.x = this.position.x - this.speed;
				break;
			case RIGHT :
				nextPosition.x = this.position.x + this.speed;
				break;
			case UP :
				nextPosition.y = this.position.y - this.speed;
				break;
			case DOWN :
				nextPosition.y = this.position.y + this.speed;
				break;
			default :
				//TODO Throw exception
				break;
		}
		
		nextPosition = recalibration(nextPosition, direction); //Repositionnement
		
		return cropping(nextPosition); //Recadrage
	}
	
	private Point cropping(Point point) {
		if (point.x < POSITION_X_MIN) {
			point.x = POSITION_X_MIN;
		} else if ((point.x + this.dimension.width) > POSITION_X_MAX) {
			point.x = POSITION_X_MAX - this.dimension.width;
		}
		
		if (point.y < POSITION_Y_MIN) {
			point.y = POSITION_Y_MIN;
		} else if ((point.y + this.dimension.height) > POSITION_Y_MAX) {
			point.y = POSITION_Y_MAX - this.dimension.height;
		}
		
		return point;
	}
	
	private Point recalibration(Point position, Direction direction) {
		if ((position.x % SPEED_MEDIUM != 0 || position.y % SPEED_MEDIUM != 0)
				&& (this.speed == SPEED_MEDIUM || this.speed == SPEED_HIGH)) {
			switch (direction) {
				case LEFT :
					position.x = (int) MathUtil.roundDown(position.x, SPEED_MEDIUM);
					break;
				case RIGHT :
					position.x = (int) MathUtil.roundUp(position.x, SPEED_MEDIUM);
					break;
				case UP :
					position.y = (int) MathUtil.roundDown(position.y, SPEED_MEDIUM);
					break;
				case DOWN :
					position.y = (int) MathUtil.roundUp(position.y, SPEED_MEDIUM);
					break;
				default :
					//TODO Throw exception
					break;
			}
		}
		
		return position;
	}
}
