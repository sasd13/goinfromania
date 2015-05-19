package util;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.item.Wall;

import java.awt.Dimension;
import java.awt.Point;

public class ArenaUtil {
	
	public static final double MINIMAL_PROPORTION_COLLISION = 0.5;
	public static final double FACTOR_DISTANCE_NEXT_TO = 0.8;

	public static ListElements getElementsInTouch(Element elementActor, ListElements listElements) {
		return detectElements(elementActor, elementActor.getPosition(), listElements);
	}
	
	public static boolean canMove(Element elementActor, Direction direction, ListElements listElements) {
		Point position = elementActor.getNextPosition(direction);
		
		if ((direction == Direction.LEFT && position.x < Element.POSITION_X_MIN) 
				|| (direction == Direction.RIGHT && position.x > Element.POSITION_X_MAX)
				|| (direction == Direction.UP && position.y < Element.POSITION_Y_MIN)
				|| (direction == Direction.DOWN && position.y > Element.POSITION_Y_MAX)) {
			return false;
		} else {
			ListElements listDetectedElements = getElementsAtNextPosition(elementActor, direction, listElements);
			
			for (int i=0; i<listDetectedElements.size(); i++) {
				if (listDetectedElements.get(i) instanceof Wall) {
					return false;
				}
			}
		}
		
		return true;
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
		if (proportion > MINIMAL_PROPORTION_COLLISION) {
			return true;
		}
		
		return false;
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
	
	public static Direction draw(Element element, ListElements listElements) {
		Direction direction = null;
		
		Point position = element.getPosition();
		
		double tokenLeft, tokenRight, tokenUp, tokenDown, tokenX, tokenY, token;
		
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
			direction = Direction.RIGHT;
		} else if (random == randomRight) {
			direction = Direction.LEFT;
		} else if (random == randomUp) {
			direction = Direction.DOWN;
		} else {
			direction = Direction.UP;
		}
		
		boolean canMove = canMove(element, direction, listElements);
		
		if (!canMove) {
			return getOpositeDirection(direction);
		}
		
		return direction;
	}
	
	public static Direction getOpositeDirection(Direction direction) {
		switch (direction) {
			case LEFT:
				return Direction.RIGHT;
			case RIGHT:
				return Direction.LEFT;
			case UP:
				return Direction.DOWN;
			case DOWN:
				return Direction.UP;
			default:
				//TODO Throw exception
				return null;
		}
	}
	
	public static Direction pursuePig(Enemy enemy, Pig pig) {	
		Direction direction = Direction.LEFT;
		
		//TODO
		
		return direction;		
	}
}
