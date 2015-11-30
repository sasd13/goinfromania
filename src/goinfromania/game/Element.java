package goinfromania.game;

import goinfromania.view.DimensionConstants;

import java.awt.Dimension;
import java.awt.Point;

public abstract class Element {
	
	public static final int POSITION_X_MIN = 0;
	public static final int POSITION_X_MAX = DimensionConstants.ARENA_WIDTH;
	public static final int POSITION_Y_MIN = 0;
	public static final int POSITION_Y_MAX = DimensionConstants.ARENA_HEIGHT;

	private Point position;
	private Dimension dimension;
	
	protected Element() {}
	
	public abstract boolean isCrossable();

	public abstract String getName();

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
}
