package goinfromania.game;

import goinfromania.view.DimensionConstants;

import java.awt.Dimension;
import java.awt.Point;

public interface IElement {
	
	int POSITION_X_MIN = 0;
	int POSITION_X_MAX = DimensionConstants.ARENA_WIDTH;
	int POSITION_Y_MIN = 0;
	int POSITION_Y_MAX = DimensionConstants.ARENA_HEIGHT;

	boolean isCrossable();

	String getName();
	
	void setName(String name);

	Point getPosition();

	void setPosition(Point position);

	Dimension getDimension();

	void setDimension(Dimension dimension);
}
