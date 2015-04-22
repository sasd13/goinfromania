package game.element;

import game.setting.Direction;
import game.setting.Position;

public abstract class Character extends Element implements IMovable {

	private Life life;
	private boolean movable;
	
	protected Character() {
		super();
		
		setTitle("Character");
		
		this.life = new Life();
		this.movable = true;
	}
	
	public Life getLife() {
		return this.life;
	}
	
	public void setLife(Life life) {
		this.life = life;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public boolean isMovable() {
		return this.movable;
	}
	
	@Override
	public void setMovable(boolean movable) {
		this.movable = movable;
		
		setChanged();
		notifyObservers();
	}
	
	@Override
	public Position move(Direction direction, Speed speed) {
		Position position = getPosition();
		
		if(!isMovable()) {
			return position;
		}
		
		switch (direction) {
			case LEFT :
				position.setX(position.getX() - speed.getValue());
				break;
			case RIGHT :
				position.setX(position.getX() + speed.getValue());
				break;
			case UP :
				position.setY(position.getY() + speed.getValue());
				break;
			case DOWN :
				position.setY(position.getY() - speed.getValue());
				break;
		}
		
		return position;
	}
}
