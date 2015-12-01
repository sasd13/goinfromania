package main.java.bean;

public interface IMovable extends IElement {

	boolean isMovable();
	
	int getSpeed();
	
	void setSpeed(int speed);
}
