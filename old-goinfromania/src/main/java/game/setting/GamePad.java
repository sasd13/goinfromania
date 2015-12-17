package main.java.game.setting;

import java.awt.event.KeyEvent;

public class GamePad extends Setting {

	public static final String NAME = "GamePad";
	
	private int keyStart;
	private int keyMoveNorth;
	private int keyMoveSouth;
	private int keyMoveWest;
	private int keyMoveEast;
	private int keyPigAttak;
	
	public GamePad() {
		super();
		
		setName(NAME);
		
		reset();
	}
	
	public int getKeyStart() {
		return this.keyStart;
	}
	
	public void setKeyStart(int keyStart) {
		this.keyStart = keyStart;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveNorth() {
		return this.keyMoveNorth;
	}
	
	public void setKeyMoveNorth(int keyMoveNorth) {
		this.keyMoveNorth = keyMoveNorth;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveSouth() {
		return this.keyMoveSouth;
	}
	
	public void setKeyMoveSouth(int keyMoveSouth) {
		this.keyMoveSouth = keyMoveSouth;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveWest() {
		return this.keyMoveWest;
	}
	
	public void setKeyMoveWest(int keyMoveWest) {
		this.keyMoveWest = keyMoveWest;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveEast() {
		return this.keyMoveEast;
	}
	
	public void setKeyMoveEast(int keyMoveEast) {
		this.keyMoveEast = keyMoveEast;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyPigAttak() {
		return this.keyPigAttak;
	}
	
	public void setKeyPigAttak(int keyPigAttak) {
		this.keyPigAttak = keyPigAttak;
		
		setChanged();
		notifyObservers();
	}

	@Override
	public void reset() {		
		setKeyStart(KeyEvent.VK_ENTER);
		setKeyMoveNorth(KeyEvent.VK_UP);
		setKeyMoveSouth(KeyEvent.VK_DOWN);
		setKeyMoveWest(KeyEvent.VK_LEFT);
		setKeyMoveEast(KeyEvent.VK_RIGHT);
		setKeyPigAttak(KeyEvent.VK_SPACE);
	}
}
