package game.element;

import game.setting.Direction;
import game.setting.Position;

public interface IMovable {

	public boolean isMovable();
	
	public void setMovable(boolean movable);
	
	public Position move(Direction direction, Speed speed);
}
