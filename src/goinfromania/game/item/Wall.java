package goinfromania.game.item;

import java.awt.Dimension;
import java.awt.Point;

import goinfromania.game.IElement;

public class Wall implements IElement {
	
	private String name;
	private Point position;
	private Dimension dimension;

	@Override
	public boolean isCrossable() {
		return false;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Point getPosition() {
		return position;
	}
	
	@Override
	public void setPosition(Point position) {
		this.position = position;
	}
	
	@Override
	public Dimension getDimension() {
		return dimension;
	}
	
	@Override
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
}
