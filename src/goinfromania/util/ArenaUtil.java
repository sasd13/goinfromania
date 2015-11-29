package goinfromania.util;

import java.awt.Dimension;
import java.awt.Point;

public class ArenaUtil {
	/*
	public static final double MINIMAL_PROPORTION_COLLISION_TO_ACT = 0.5;
	public static final double FACTOR_DISTANCE_NEXT_TO = 1.5;

	public static boolean canMoveInDirection(Element elementActor, Direction direction, ListElements listElements) {
		Point position = elementActor.getNextPosition(direction);
		
		if (elementActor instanceof Power) {
			return true;
		}
		
		if ((direction == Direction.WEST && position.x < Element.POSITION_X_MIN) 
				|| (direction == Direction.EAST && position.x > Element.POSITION_X_MAX)
				|| (direction == Direction.NORTH && position.y < Element.POSITION_Y_MIN)
				|| (direction == Direction.SOUTH && position.y > Element.POSITION_Y_MAX)) {
			return false;
		} else {
			ListElements listElementsAtNextPosition = getElementsAtNextPosition(elementActor, direction, listElements);
			
			for (int i=0; i<listElementsAtNextPosition.size(); i++) {
				if (listElementsAtNextPosition.get(i) instanceof Wall) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static ListElements getElementsInTouch(Element elementActor, ListElements listElements) {
		return detectElements(elementActor, elementActor.getPosition(), listElements);
	}
	
	public static ListElements getElementsAtNextPosition(Element elementActor, Direction direction, ListElements listElements) {
		return detectElements(elementActor, elementActor.getNextPosition(direction), listElements);
	}
	
	public static ListElements detectElements(Element elementActor, Point position, ListElements listElements) {
		ListElements listDetectedElement = new ListElements();
		
		boolean detected;
		
		Element elementSusceptible;
		for (int i=0; i<listElements.size(); i++) {
			elementSusceptible = listElements.get(i);
			
			if (elementSusceptible != elementActor) {
				detected = MathUtil.isCollide(position, elementActor.getDimension(), elementSusceptible.getPosition(), elementSusceptible.getDimension());
				if (detected) {
					listDetectedElement.add(elementSusceptible);
				}
			}
		}
		
		return listDetectedElement;
	}
	
	public static boolean canActInTouch(Element elementActor, Element elementToAct) {
		Point position1 = elementActor.getPosition();
		Dimension dimension1 = elementActor.getDimension();
		
		Point position2 = elementToAct.getPosition();
		Dimension dimension2 = elementToAct.getDimension();
		
		double proportion = MathUtil.getMinimalProportionCollision(position1, dimension1, position2, dimension2);
		
		return proportion > MINIMAL_PROPORTION_COLLISION_TO_ACT;
	}
	
	public static ListElements getElementsNextTo(Element elementActor, ListElements listElements) {
		ListElements listElementsNextTo = new ListElements();
		
		boolean canAct;
		
		Element elementToAct;
		for (int i=0; i<listElements.size(); i++) {
			elementToAct = listElements.get(i);
			
			if (elementToAct != elementActor) {
				canAct = canActNextTo(elementActor, elementToAct);
				if (canAct) {
					listElementsNextTo.add(elementToAct);
				}
			}
		}
		
		return listElementsNextTo;
	}
	
	public static boolean canActNextTo(Element elementActor, Element elementToAct) {
		Point position1 = elementActor.getPosition();
		Dimension dimension1 = elementActor.getDimension();
		
		Point position2 = elementToAct.getPosition();
		Dimension dimension2 = elementToAct.getDimension();
		
		return isNextTo(position1, dimension1, position2, dimension2);
	}
	
	public static boolean isNextTo(Point position1, Dimension dimension1, Point position2, Dimension dimension2) {
		Point gravityPosition1 = MathUtil.getGravityPosition(position1, dimension1);
		Point gravityPosition2 = MathUtil.getGravityPosition(position2, dimension2);
		
		double distanceNextTo, distanceGravities, diagonal1, diagonal2;
		distanceGravities = MathUtil.distance(gravityPosition1, gravityPosition2);
		diagonal1 = MathUtil.measureDiagonal(dimension1.width, dimension1.height);
		diagonal2 = MathUtil.measureDiagonal(dimension2.width, dimension2.height);
		
		if (diagonal1 > diagonal2) {
			distanceNextTo = diagonal1*FACTOR_DISTANCE_NEXT_TO;
		} else {
			distanceNextTo = diagonal2*FACTOR_DISTANCE_NEXT_TO;
		}
		
		return distanceGravities <= distanceNextTo;
	}
	
	public static Direction getRandomDirection(Element element) {
		Direction direction = null;
		
		Point position = element.getPosition();
		
		double tokenLeft, tokenRight, tokenUp, tokenDown;
		
		tokenLeft = 1000*position.x / Element.POSITION_X_MAX;
		tokenRight = 1000 - tokenLeft;
		
		tokenUp = 1000*position.y / Element.POSITION_Y_MAX;
		tokenDown = 1000 - tokenUp;
		
		double randomLeft, randomRight, randomUp, randomDown, randomX, randomY, random;
		
		randomLeft = Math.random()*tokenLeft;
		randomRight = Math.random()*tokenRight;
		randomUp = Math.random()*tokenUp;
		randomDown = Math.random()*tokenDown;
		
		randomX = (randomLeft < randomRight) ? randomLeft : randomRight;
		randomY = (randomUp < randomDown) ? randomUp : randomDown;
		random = (randomX < randomY) ? randomX : randomY;
		
		if (random == randomLeft) {
			direction = Direction.EAST;
		} else if (random == randomRight) {
			direction = Direction.WEST;
		} else if (random == randomUp) {
			direction = Direction.SOUTH;
		} else {
			direction = Direction.NORTH;
		}
		
		return direction;
	}
	
	public static Direction getOpositeDirection(Direction direction) {
		switch (direction) {
			case WEST:
				return Direction.EAST;
			case EAST:
				return Direction.WEST;
			case NORTH:
				return Direction.SOUTH;
			case SOUTH:
				return Direction.NORTH;
			default:
				//TODO Throw exception
				return null;
		}
	}
	
	public static Direction pursue(Element elementActor, Element elementToAct) {	
		Direction directionX, directionY;
		int distanceX, distanceY;
		
		distanceX = elementActor.getPosition().x - elementToAct.getPosition().x;
		if (distanceX < 0) {
			directionX = Direction.EAST;
		} else {
			directionX = Direction.WEST;
		}
		
		distanceY = elementActor.getPosition().y - elementToAct.getPosition().y;
		if (distanceY < 0) {
			directionY = Direction.SOUTH;
		} else {
			directionY = Direction.NORTH;
		}
		
		return (Math.abs(distanceX) > Math.abs(distanceY)) ? directionX : directionY;		
	}
	*/
}
