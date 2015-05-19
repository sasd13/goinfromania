package util;

import game.element.Direction;
import game.element.Element;

import java.awt.Dimension;
import java.awt.Point;

public class ElementUtil {
	
	public static Point recalibration(Point position, Direction direction, int speed) {
		if ((speed == Element.SPEED_MEDIUM) 
				&& (position.x % Element.SPEED_MEDIUM != 0 || position.y % Element.SPEED_MEDIUM != 0)) {
			switch (direction) {
				case LEFT :
					position.x = (int) MathUtil.roundDown(position.x, Element.SPEED_MEDIUM);
					break;
				case RIGHT :
					position.x = (int) MathUtil.roundUp(position.x, Element.SPEED_MEDIUM);
					break;
				case UP :
					position.y = (int) MathUtil.roundDown(position.y, Element.SPEED_MEDIUM);
					break;
				case DOWN :
					position.y = (int) MathUtil.roundUp(position.y, Element.SPEED_MEDIUM);
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
