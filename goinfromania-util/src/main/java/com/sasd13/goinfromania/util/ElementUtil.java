package com.sasd13.goinfromania.util;

import java.awt.Point;

import com.sasd13.goinfromania.bean.Direction;

public class ElementUtil {
	
	public static Point recalibration(Point position, Direction direction, int speed) {
		if ((speed == GameConstants.SPEED_MEDIUM) 
				&& (position.x % GameConstants.SPEED_MEDIUM != 0 || position.y % GameConstants.SPEED_MEDIUM != 0)) {
			switch (direction) {
				case WEST :
					position.x = (int) MathUtil.roundDown(position.x, GameConstants.SPEED_MEDIUM);
					break;
				case EAST :
					position.x = (int) MathUtil.roundUp(position.x, GameConstants.SPEED_MEDIUM);
					break;
				case NORTH :
					position.y = (int) MathUtil.roundDown(position.y, GameConstants.SPEED_MEDIUM);
					break;
				case SOUTH :
					position.y = (int) MathUtil.roundUp(position.y, GameConstants.SPEED_MEDIUM);
					break;
				default :
					//TODO Throw exception
					break;
			}
		}
		
		return position;
	}
}
