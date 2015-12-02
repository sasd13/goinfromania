package com.sasd13.goinfromania.bean;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Observable;

public abstract class Element extends Observable implements IElement {
	
	private int id;
	private Point position;
	private Dimension dimension;
	private boolean crossable;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public Point getPosition() {
		return position;
	}
	
	@Override
	public void setPosition(Point position) {
		this.position = position;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public Dimension getDimension() {
		return dimension;
	}
	
	@Override
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public boolean isCrossable() {
		return crossable;
	}
	
	@Override
	public void setCrossable(boolean crossable) {
		this.crossable = crossable;
		
		setChanged();
		notifyObservers();
	}
}
