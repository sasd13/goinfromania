package goinfromania;

public interface IMovable {

	boolean isMovable();
	
	void move(Direction direction);
	
	int getSpeed();
	
	void setSpeed(int speed);
}
