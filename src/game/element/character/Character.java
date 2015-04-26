package game.element.character;

import game.element.Element;
import game.element.power.MapPower;
import game.round.Score;

public abstract class Character extends Element {
	
	private boolean died;
	private Life life;
	private boolean powerful;
	private MapPower mapPower;
	
	protected Character() {
		super();
		
		setMovable(true);
		setSpeed(Element.SPEED_MEDIUM);
		
		this.died = false;
		this.life = new Life();
		this.powerful = false;
		this.mapPower = null;
	}
	
	public boolean isDied() {
		return this.died;
	}
	
	public void setDied(boolean died) {
		this.died = died;
		
		setChanged();
		notifyAll();
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
	
	public void checkLife() {
		if (this.life.getValue() == Life.LIFE_MIN) {
			this.died = true;
		}
	}
	
	public abstract Score attak(Character character);
}
