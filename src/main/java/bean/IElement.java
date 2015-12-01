package main.java.bean;

import java.awt.Dimension;
import java.awt.Point;

public interface IElement {
	
	String getName();
	
	void setName(String name);

	Point getPosition();

	void setPosition(Point position);

	Dimension getDimension();

	void setDimension(Dimension dimension);
	
	boolean isCrossable();
	
	void setCrossable(boolean crossable);
}
