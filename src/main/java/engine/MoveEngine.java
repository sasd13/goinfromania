package main.java.engine;

import java.awt.Dimension;
import java.awt.Point;

import main.java.bean.Direction;
import main.java.bean.IMovable;
import main.java.view.DimensionConstants;

public class MoveEngine {
	
	public static final int POSITION_X_MIN = 0;
	public static final int POSITION_X_MAX = DimensionConstants.ARENA_WIDTH;
	public static final int POSITION_Y_MIN = 0;
	public static final int POSITION_Y_MAX = DimensionConstants.ARENA_HEIGHT;

	public static void move(IMovable movable, Direction direction) {
		movable.setPosition(getNextPosition(movable, direction));
	}
	
	public static Point getNextPosition(IMovable movable, Direction direction) {
		Point position = movable.getPosition();
		int speed = movable.getSpeed();
		
		Point nextPosition = new Point();
		
		switch (direction) {
			case NORTH :
				nextPosition.y = position.y - speed;
				break;
			case SOUTH :
				nextPosition.y = position.y + speed;
				break;
			case WEST :
				nextPosition.x = position.x - speed;
				break;
			case EAST :
				nextPosition.x = position.x + speed;
				break;
		}
		
		return cropping(nextPosition, movable.getDimension());
	}
	
	private static Point cropping(Point position, Dimension dimension) {
		if (position.x < POSITION_X_MIN) {
			position.x = POSITION_X_MIN;
		} else if ((position.x + dimension.width) > POSITION_X_MAX) {
			position.x = POSITION_X_MAX - dimension.width;
		}
		
		if (position.y < POSITION_Y_MIN) {
			position.y = POSITION_Y_MIN;
		} else if ((position.y + dimension.height) > POSITION_Y_MAX) {
			position.y = POSITION_Y_MAX - dimension.height;
		}
		
		return position;
	}
}
