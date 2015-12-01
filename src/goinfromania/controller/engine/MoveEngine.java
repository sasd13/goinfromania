package goinfromania.controller.engine;

import java.awt.Dimension;
import java.awt.Point;

import goinfromania.game.Direction;
import goinfromania.game.Element;
import goinfromania.game.IMovable;

public class MoveEngine {

	public static void move(IMovable movable, Direction direction) {
		Element element = (Element) movable;
		
		Point nextPosition = getNextPosition(element, direction, movable.getSpeed());
		
		element.setPosition(nextPosition);
	}
	
	public static Point getNextPosition(Element element, Direction direction, int speed) {
		Point position = element.getPosition();
		
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
		
		nextPosition = cropping(nextPosition, element.getDimension());
		
		return nextPosition;
	}
	
	private static Point cropping(Point position, Dimension dimension) {
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
