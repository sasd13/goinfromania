package com.sasd13.goinfromania.util;

import java.awt.Dimension;
import java.awt.Point;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.IMovable;

public class MoveUtil {
	
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
		if (position.x < GameConstants.POSITION_X_MIN) {
			position.x = GameConstants.POSITION_X_MIN;
		} else if ((position.x + dimension.width) > GameConstants.POSITION_X_MAX) {
			position.x = GameConstants.POSITION_X_MAX - dimension.width;
		}
		
		if (position.y < GameConstants.POSITION_Y_MIN) {
			position.y = GameConstants.POSITION_Y_MIN;
		} else if ((position.y + dimension.height) > GameConstants.POSITION_Y_MAX) {
			position.y = GameConstants.POSITION_Y_MAX - dimension.height;
		}
		
		return position;
	}
}
