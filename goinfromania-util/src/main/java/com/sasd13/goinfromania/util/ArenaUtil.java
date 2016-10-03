package com.sasd13.goinfromania.util;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.sasd13.goinfromania.bean.Direction;
import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.bean.IMovable;
import com.sasd13.goinfromania.bean.IPower;
import com.sasd13.goinfromania.bean.item.Wall;

public class ArenaUtil {

	public static final double MINIMAL_PROPORTION_COLLISION_TO_ACT = 0.5;
	public static final double FACTOR_DISTANCE_NEXT_TO = 1.5;

	public static boolean canMoveInDirection(IMovable elementActor, Direction direction, List<IElement> elements) {
		Point position = MoveUtil.getNextPosition(elementActor, direction);

		if (elementActor instanceof IPower) {
			return true;
		}

		if ((direction == Direction.WEST && position.x < GameConstants.POSITION_X_MIN) || (direction == Direction.EAST && position.x > GameConstants.POSITION_X_MAX) || (direction == Direction.NORTH && position.y < GameConstants.POSITION_Y_MIN) || (direction == Direction.SOUTH && position.y > GameConstants.POSITION_Y_MAX)) {
			return false;
		} else {
			List<IElement> listElementsAtNextPosition = getElementsAtNextPosition(elementActor, direction, elements);

			for (int i = 0; i < listElementsAtNextPosition.size(); i++) {
				if (listElementsAtNextPosition.get(i) instanceof Wall) {
					return false;
				}
			}
		}

		return true;
	}

	public static List<IElement> getElementsInTouch(IElement elementActor, List<IElement> listElements) {
		return detectElements(elementActor, elementActor.getPosition(), listElements);
	}

	public static List<IElement> getElementsAtNextPosition(IElement elementActor, Direction direction, List<IElement> listElements) {
		return detectElements(elementActor, MoveUtil.getNextPosition((IMovable) elementActor, direction), listElements);
	}

	public static List<IElement> detectElements(IElement elementActor, Point position, List<IElement> listElements) {
		List<IElement> detectedElements = new ArrayList<>();

		boolean detected;

		IElement susceptibleElement;
		for (int i = 0; i < listElements.size(); i++) {
			susceptibleElement = listElements.get(i);

			if (susceptibleElement != elementActor) {
				detected = MathUtil.isCollide(position, elementActor.getDimension(), susceptibleElement.getPosition(), susceptibleElement.getDimension());
				if (detected) {
					detectedElements.add(susceptibleElement);
				}
			}
		}

		return detectedElements;
	}

	public static boolean canActInTouch(IElement elementActor, IElement elementToAct) {
		Point position1 = elementActor.getPosition();
		Dimension dimension1 = elementActor.getDimension();

		Point position2 = elementToAct.getPosition();
		Dimension dimension2 = elementToAct.getDimension();

		double proportion = MathUtil.getMinimalProportionCollision(position1, dimension1, position2, dimension2);

		return proportion > MINIMAL_PROPORTION_COLLISION_TO_ACT;
	}

	public static List<IElement> getElementsNextTo(IElement elementActor, List<IElement> listElements) {
		List<IElement> elementsNextTo = new ArrayList<>();

		boolean canAct;

		IElement elementToAct;
		for (int i = 0; i < listElements.size(); i++) {
			elementToAct = listElements.get(i);

			if (elementToAct != elementActor) {
				canAct = canActNextTo(elementActor, elementToAct);
				if (canAct) {
					elementsNextTo.add(elementToAct);
				}
			}
		}

		return elementsNextTo;
	}

	public static boolean canActNextTo(IElement elementActor, IElement elementToAct) {
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
			distanceNextTo = diagonal1 * FACTOR_DISTANCE_NEXT_TO;
		} else {
			distanceNextTo = diagonal2 * FACTOR_DISTANCE_NEXT_TO;
		}

		return distanceGravities <= distanceNextTo;
	}

	public static Direction getRandomDirection(IElement element) {
		Direction direction = null;

		Point position = element.getPosition();

		double tokenLeft, tokenRight, tokenUp, tokenDown;

		tokenLeft = 1000 * position.x / GameConstants.POSITION_X_MAX;
		tokenRight = 1000 - tokenLeft;

		tokenUp = 1000 * position.y / GameConstants.POSITION_Y_MAX;
		tokenDown = 1000 - tokenUp;

		double randomLeft, randomRight, randomUp, randomDown, randomX, randomY, random;

		randomLeft = Math.random() * tokenLeft;
		randomRight = Math.random() * tokenRight;
		randomUp = Math.random() * tokenUp;
		randomDown = Math.random() * tokenDown;

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
				// TODO Throw exception
				return null;
		}
	}

	public static Direction pursue(IElement elementActor, IElement elementToAct) {
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
}
