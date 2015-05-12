package game.util;

import java.awt.Dimension;
import java.awt.Point;

public class MathUtil {

	public static double roundUp(double value, double round) {
		return Math.ceil(value/round) * round;
	}
	
	public static double roundDown(double value, double round) {
		return Math.floor(value/round) * round;
	}
	
	public static double distance(Point point1, Point point2) {
		double distance = Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow((point1.y - point2.y), 2));
		
		return distance;
	}
	
	public static double measureDiagonal(double width, double height) {
		double diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		
		return diagonal;
	}
	
	public static Point getGravityPosition(Point position, Dimension dimension) {
		Point gravityPosition = new Point();
		
		gravityPosition.x = (2*position.x + dimension.width) / 2;
		gravityPosition.y = (2*position.y + dimension.height) / 2;
		
		return gravityPosition;
	}
	
	public static boolean isCollide(Point position1, Dimension dimension1, Point position2, Dimension dimension2) {
		if (position1.equals(position2)
				|| (position1.x < position2.x + dimension2.width
						&& position2.x < position1.x + dimension1.width
						&& position1.y < position2.y + dimension2.height
						&& position2.y < position1.y + dimension1.height)) {
			return true;
		}
		
		return false;
	}
	
	public static double getMinimalProportionCollision(Point position1, Dimension dimension1, Point position2, Dimension dimension2) {
		boolean detected = MathUtil.isCollide(position1, dimension1, position2, dimension2);
		
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
}
