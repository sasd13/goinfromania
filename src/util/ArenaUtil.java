package util;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Pig;

import java.awt.Dimension;
import java.awt.Point;

public class ArenaUtil {

	public static ListElements getDetectedElementsAtPigPosition(ListElements listElements) {
		Pig pig = listElements.getPig();
		
		Point position = pig.getPosition();
		
		return pigDetectElements(position, listElements);
	}
	
	public static ListElements getDetectedElementsAtNextPigPosition(ListElements listElements, Direction direction) {
		Pig pig = listElements.getPig();
		
		Point position = pig.getNextPosition(direction);
		
		return pigDetectElements(position, listElements);
	}
	
	private static ListElements pigDetectElements(Point position, ListElements listElements) {
		ListElements listDetectedElement = new ListElements();
		
		Pig pig = listElements.getPig();
		
		boolean detected;
		
		Element element;
		for (int i=0; i<listElements.size(); i++) {
			element = listElements.get(i);
			
			if (!(element instanceof Pig)) {
				detected = detectCollision(position, pig.getDimension(), element.getPosition(), element.getDimension());
				if (detected) {
					listDetectedElement.add(element);
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
	
	public static double getProportionCollision(Point position1, Dimension dimension1, Point position2, Dimension dimension2) {
		boolean detected = detectCollision(position1, dimension1, position2, dimension2);
		
		if (detected) {
			//TODO Calculer marge surface de collision
		}
		
		return 0;
	}
}
