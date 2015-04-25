package game.element.character;

import game.element.Element;
import game.element.Speed;
import game.element.power.MapPower;

public abstract class Character extends Element {

	private boolean alive;
	private Life life;
	private boolean powerful;
	private MapPower mapPower;
	
	protected Character() {
		super();
		
		setMovable(true);
		setSpeed(new Speed(Speed.SPEED_MEDIUM));
		
		this.alive = true;
		this.life = new Life();
		this.powerful = false;
		this.mapPower = null;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
		
		setChanged();
		notifyObservers();
	}
	
	public Life getLife() {
		return this.life;
	}
	
	public void setLife(Life life) {
		this.life = life;
		
		setChanged();
		notifyObservers();
	}
	
	public boolean isPowerful() {
		return this.powerful;
	}
	
	public void setPowerful(boolean powerful) {
		this.powerful = powerful;
		
		setChanged();
		notifyObservers();
	}
	
	public MapPower getMapPower() {
		return this.mapPower;
	}
	
	public void setMapPower(MapPower mapPower) {
		this.mapPower = mapPower;
		
		setChanged();
		notifyObservers();
	}
	
	public abstract void attak(Character character);
}
