package goinfromania.engine;

import java.awt.Dimension;
import java.awt.Point;

import goinfromania.game.Direction;
import goinfromania.game.IElement;
import goinfromania.game.IMovable;

public class MoveEngine {

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
		if (position.x < IElement.POSITION_X_MIN) {
			position.x = IElement.POSITION_X_MIN;
		} else if ((position.x + dimension.width) > IElement.POSITION_X_MAX) {
			position.x = IElement.POSITION_X_MAX - dimension.width;
		}
		
		if (position.y < IElement.POSITION_Y_MIN) {
			position.y = IElement.POSITION_Y_MIN;
		} else if ((position.y + dimension.height) > IElement.POSITION_Y_MAX) {
			position.y = IElement.POSITION_Y_MAX - dimension.height;
		}
		
		return position;
	}
}
