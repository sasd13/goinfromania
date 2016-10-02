package com.sasd13.goinfromania.bean.setting;

import java.awt.event.KeyEvent;

public class Gamepad extends Setting {

	private int keyStart, keyMoveNorth, keyMoveSouth, keyMoveWest, keyMoveEast, keyPigAttak;
	
	@Override
	public String getCode() {
		return EnumSetting.GAMEPAD.getCode();
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
	
	public int getKeyStart() {
		return keyStart;
	}
	
	public void setKeyStart(int keyStart) {
		this.keyStart = keyStart;
		
		setChanged();
		notifyObservers();		
	}
	
	public int getKeyMoveNorth() {
		return keyMoveNorth;
	}
	
	public void setKeyMoveNorth(int keyMoveNorth) {
		this.keyMoveNorth = keyMoveNorth;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveSouth() {
		return keyMoveSouth;
	}
	
	public void setKeyMoveSouth(int keyMoveSouth) {
		this.keyMoveSouth = keyMoveSouth;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveWest() {
		return keyMoveWest;
	}
	
	public void setKeyMoveWest(int keyMoveWest) {
		this.keyMoveWest = keyMoveWest;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveEast() {
		return keyMoveEast;
	}
	
	public void setKeyMoveEast(int keyMoveEast) {
		this.keyMoveEast = keyMoveEast;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyPigAttak() {
		return keyPigAttak;
	}
	
	public void setKeyPigAttak(int keyPigAttak) {
		this.keyPigAttak = keyPigAttak;
		
		setChanged();
		notifyObservers();
	}
}
