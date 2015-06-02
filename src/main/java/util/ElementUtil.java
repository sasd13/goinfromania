package main.java.util;

import java.awt.Dimension;
import java.awt.Point;

import main.java.game.element.Direction;
import main.java.game.element.Element;
import main.java.game.element.character.Pig;

public class ElementUtil {
	
	public static Point recalibration(Point position, Direction direction, int speed) {
		if ((speed == Pig.SPEED_MEDIUM) 
				&& (position.x % Pig.SPEED_MEDIUM != 0 || position.y % Pig.SPEED_MEDIUM != 0)) {
			switch (direction) {
				case WEST :
					position.x = (int) MathUtil.roundDown(position.x, Pig.SPEED_MEDIUM);
					break;
				case EAST :
					position.x = (int) MathUtil.roundUp(position.x, Pig.SPEED_MEDIUM);
					break;
				case NORTH :
					position.y = (int) MathUtil.roundDown(position.y, Pig.SPEED_MEDIUM);
					break;
				case SOUTH :
					position.y = (int) MathUtil.roundUp(position.y, Pig.SPEED_MEDIUM);
					break;
				default :
					//TODO Throw exception
					break;
			}
		}
		
		return position;
	}
	
	public static Point cropping(Point position, Dimension dimension) {
		if (position.x < Element.POSITION_X_MIN) {
			position.x = Element.POSITION_X_MIN;
		} else if ((position.x + dimension.width) > Element.POSITION_X_MAX) {
			position.x = Element.POSITION_X_MAX - dimension.width;
		}
		
		if (position.y < Element.POSITION_Y_MIN) {
			position.y = Element.POSITION_Y_MIN;
		} else if ((position.y + dimension.height) > Element.POSITION_Y_MAX) {
			position.y = Element.POSITION_Y_MAX - dimension.height;
		}
		
		return position;
	}
}
