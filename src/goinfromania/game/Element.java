package goinfromania.game;

import java.awt.Dimension;
import java.awt.Point;

public abstract class Element {

	private String name;
	private Point position;
	private Dimension dimension;
	
	public Element() {}
	
	public abstract boolean isCrossable();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
