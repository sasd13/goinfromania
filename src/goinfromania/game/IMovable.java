package goinfromania.game;

public interface IMovable extends IElement {

	boolean isMovable();
	
	int getSpeed();
	
	void setSpeed(int speed);
}
