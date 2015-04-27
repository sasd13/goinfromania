package game.setting;

import java.awt.event.KeyEvent;

public class GamePad extends Setting {

	public static final String NAME = "GamePad";
	
	private int keyStart;
	private int keyMoveLeft;
	private int keyMoveRight;
	private int keyMoveUp;
	private int keyMoveDown;
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
	
	public int getKeyMoveLeft() {
		return this.keyMoveLeft;
	}
	
	public void setKeyMoveLeft(int keyMoveLeft) {
		this.keyMoveLeft = keyMoveLeft;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveRight() {
		return this.keyMoveRight;
	}
	
	public void setKeyMoveRight(int keyMoveRight) {
		this.keyMoveRight = keyMoveRight;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveUp() {
		return this.keyMoveUp;
	}
	
	public void setKeyMoveUp(int keyMoveUp) {
		this.keyMoveUp = keyMoveUp;
		
		setChanged();
		notifyObservers();
	}
	
	public int getKeyMoveDown() {
		return this.keyMoveDown;
	}
	
	public void setKeyMoveDown(int keyMoveDown) {
		this.keyMoveDown = keyMoveDown;
		
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
		setKeyMoveLeft(KeyEvent.VK_LEFT);
		setKeyMoveRight(KeyEvent.VK_RIGHT);
		setKeyMoveUp(KeyEvent.VK_UP);
		setKeyMoveDown(KeyEvent.VK_DOWN);
		setKeyPigAttak(KeyEvent.VK_SPACE);
	}
}
