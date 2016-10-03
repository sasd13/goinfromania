package com.sasd13.goinfromania.util;

import java.awt.Point;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.IMovable;

public class MoveUtil {

	public static Point getNextPosition(IMovable movable, Direction direction) {
		Point position = movable.getPosition();
		int speed = movable.getSpeed();

		Point nextPosition = new Point(position);

		switch (direction) {
			case NORTH:
				nextPosition.y = position.y - speed;
				break;
			case SOUTH:
				nextPosition.y = position.y + speed;
				break;
			case WEST:
				nextPosition.x = position.x - speed;
				break;
			case EAST:
				nextPosition.x = position.x + speed;
				break;
		}

		return nextPosition;
	}
}
