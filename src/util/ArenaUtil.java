package util;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.item.Wall;

import java.awt.Dimension;
import java.awt.Point;

public class ArenaUtil {
	
	public static final double MINIMAL_PROPORTION_COLLISION = 0.5;
	public static final double FACTOR_DISTANCE_NEXT_TO = 0.8;

	public static boolean canMove(Element elementActor, Direction direction, ListElements listElements) {
		ListElements listDetectedElements = getElementsAtNextPosition(elementActor, listElements, direction);
		
		for (int i=0; i<listDetectedElements.size(); i++) {
			if (listDetectedElements.get(i) instanceof Wall) {
				return false;
			}
		}
		
		return true;
	}
	
	public static ListElements getElementsAtNextPosition(Element elementActor, ListElements listElements, Direction direction) {
		Point nextPosition = elementActor.getNextPosition(direction);
		
		return detectElements(elementActor, nextPosition, listElements);
	}
	
	public static ListElements detectElements(Element elementActor, Point position, ListElements listElements) {
		ListElements listDetectedElement = new ListElements();
		
		boolean detected;
		
		Element elementToAct;
		for (int i=0; i<listElements.size(); i++) {
			elementToAct = listElements.get(i);
			
			if (elementToAct != elementActor) {
				detected = detectCollision(position, elementActor.getDimension(), elementToAct.getPosition(), elementToAct.getDimension());
				if (detected) {
					listDetectedElement.add(elementToAct);
				}
			}
		}
		
		return listDetectedElement;
	}
	
	public static boolean detectCollision(Point position1, Dimension dimension1, Point position2, Dimension dimension2) {
		if (position1.equals(position2)
				|| (position1.x < position2.x + dimension2.width
						&& position2.x < position1.x + dimension1.width
						&& position1.y < position2.y + dimension2.height
						&& position2.y < position1.y + dimension1.height)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean canActInTouch(Element elementActor, Element elementToAct) {
		Point position1 = elementActor.getPosition();
		Dimension dimension1 = elementActor.getDimension();
		
		Point position2 = elementToAct.getPosition();
		Dimension dimension2 = elementToAct.getDimension();
		
		double proportion = ArenaUtil.getMinimalProportionCollision(position1, dimension1, position2, dimension2);
		
		if (proportion > MINIMAL_PROPORTION_COLLISION) {
			return true;
		}
		
		return false;
	}
	
	public static double getMinimalProportionCollision(Point position1, Dimension dimension1, Point position2, Dimension dimension2) {
		boolean detected = detectCollision(position1, dimension1, position2, dimension2);
		
		if (!detected) {
			return 0;
		}
		
		int widthCollision = 0, heightCollision = 0;
		
		if (position1.x > position2.x && position1.x + dimension1.width < position2.x + dimension2.width) {
			widthCollision = dimension1.width;
		} else if (position2.x > position1.x && position2.x + dimension2.width < position1.x + dimension1.width) {
			widthCollision = dimension2.width;
		} else {
			widthCollision = (position1.x < position2.x)
					? position1.x + dimension1.width - position2.x
					: position2.x + dimension2.width - position1.x;
		}
		
		if (position1.y > position2.y && position1.y + dimension1.height < position2.y + dimension2.height) {
			widthCollision = dimension1.height;
		} else if (position2.y > position1.y && position2.y + dimension2.height < position1.y + dimension1.height) {
			heightCollision = dimension2.height;
		} else {
			heightCollision = (position1.y < position2.y)
					? position1.y + dimension1.height - position2.y
					: position2.y + dimension2.height - position1.y;
		}
		
		double area1, area2, areaCollision, proportion1, proportion2;
		area1 = dimension1.width*dimension1.height;
		area2 = dimension2.width*dimension2.height;
		areaCollision = widthCollision*heightCollision;
		
		proportion1 = areaCollision/area1;
		proportion2 = areaCollision/area2;
		
		return (proportion1 < proportion2) ? proportion1 : proportion2;
	}
	
	public static ListElements getElementsInTouch(Element elementActor, ListElements listElements) {
		Point position = elementActor.getPosition();
		
		return detectElements(elementActor, position, listElements);
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
		
		boolean isNextTo = isNextTo(position1, dimension1, position2, dimension2);
		
		return isNextTo;
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
}
