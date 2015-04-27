package game.element.character;

import game.element.Element;
import game.element.power.MapPower;
import game.round.Score;

public abstract class Character extends Element {
	
	public static final int LIFE_MIN = 0;
	public static final int LIFE_MAX = 100;
	
	public static final int LIFE_LOW = 20;
	public static final int LIFE_MEDIUM = 50;
	public static final int LIFE_HIGH = 80;
	
	private boolean died;
	private int life;
	private boolean powerful;
	private MapPower mapPower;
	
	protected Character() {
		super();
		
		setMovable(true);
		setSpeed(Element.SPEED_MEDIUM);
		
		this.died = false;
		this.life = LIFE_MAX;
		this.powerful = false;
		this.mapPower = null;
	}
	
	public boolean isDied() {
		return this.died;
	}
	
	public void setDied(boolean died) {
		this.died = died;
		
		setChanged();
		notifyObservers();
		
		if (this.died) {
			setVisible(false);
		}
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void setLife(int life) {
		if (life <= LIFE_MIN) {
			this.life = LIFE_MIN;
		} else if (life >= LIFE_MAX) {
			this.life = LIFE_MAX;
		} else {
			this.life = life;
		}
		
		setChanged();
		notifyObservers();
		
		if (this.life == LIFE_MIN) {
			setDied(true);
		}
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
	
	public abstract Score attak(Character character);
}
