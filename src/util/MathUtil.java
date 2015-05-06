package util;

import java.awt.Dimension;
import java.awt.Point;

public class MathUtil {

	public static double distance (Point point1, Point point2) {
		double distance = Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow((point1.y - point2.y), 2));
		return distance;
	}
	
	public static Point getGravityPosition(Point position, Dimension dimension) {
		Point gravityPosition = new Point();
		
		gravityPosition.x = (2*position.x + dimension.width) / 2;
		gravityPosition.y = (2*position.y + dimension.height) / 2;
		
		return gravityPosition;
	}
	
	public static double roundUp(double value, double round) {
		return Math.ceil(value/round) * round;
	}
	
	public static double roundDown(double value, double round) {
		return Math.floor(value/round) * round;
	}
}
