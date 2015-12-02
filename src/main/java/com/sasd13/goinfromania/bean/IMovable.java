package com.sasd13.goinfromania.bean;

public interface IMovable extends IElement {

	boolean isMovable();
	
	void setMovable(boolean movable);
	
	int getSpeed();
	
	void setSpeed(int speed);
}
