package game.element.character;

import game.element.Element;

public abstract class Character extends Element {
	
	public static final int LIFE_MIN = 0;
	public static final int LIFE_LOW = 20;
	public static final int LIFE_MEDIUM = 50;
	public static final int LIFE_HIGH = 80;
	public static final int LIFE_MAX = 100;
	
	private boolean died;
	private int life;
	private boolean powerful;
	
	protected Character() {
		super();
		
		setMovable(true);
		setSpeed(SPEED_MEDIUM);
		
		this.died = false;
		this.life = LIFE_MAX;
		this.powerful = false;
	}
	
	public boolean isDied() {
		return this.died;
	}
	
	public void setDied(boolean died) {
		this.died = died;
		
		setChanged();
		notifyObservers();
	}
	
	public int getLife() {
		return this.life;
	}
	
	public void setLife(int life) {
		if (life < LIFE_MIN) {
			this.life = LIFE_MIN;
		} else if (life > LIFE_MAX) {
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
}
