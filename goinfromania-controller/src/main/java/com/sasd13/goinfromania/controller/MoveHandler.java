package com.sasd13.goinfromania.controller;

import java.awt.Dimension;
import java.awt.Point;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.IMovable;
import com.sasd13.goinfromania.util.GameConstants;
import com.sasd13.goinfromania.util.MoveUtil;

public class MoveHandler {

	public static void move(IMovable movable, Direction direction) {
		Point nextPosition = cropping(MoveUtil.getNextPosition(movable, direction), movable.getDimension());

		movable.setPosition(nextPosition);
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
