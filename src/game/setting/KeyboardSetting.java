package game.setting;

import java.awt.event.KeyEvent;

public class KeyboardSetting extends Setting {

	private int keyStart;
	private int keyPause;
	private int keyMoveLeft;
	private int keyMoveRight;
	private int keyMoveUp;
	private int keyMoveDown;
	private int keyPigAttak;
	
	public KeyboardSetting() {
		super();
		
		reset();
	}
	
	public int getKeyStart() {
		return this.keyStart;
	}
	
	public void setKeyStart(int keyStart) {
		this.keyStart = keyStart;
		
		notifyObservers();
	}
	
	public int getKeyPause() {
		return this.keyPause;
	}
	
	public void setKeyPause(int keyPause) {
		this.keyPause = keyPause;
		
		notifyObservers();
	}
	
	public int getKeyMoveLeft() {
		return this.keyMoveLeft;
	}
	
	public void setKeyMoveLeft(int keyMoveLeft) {
		this.keyMoveLeft = keyMoveLeft;
		
		notifyObservers();
	}
	
	public int getKeyMoveRight() {
		return this.keyMoveRight;
	}
	
	public void setKeyMoveRight(int keyMoveRight) {
		this.keyMoveRight = keyMoveRight;
		
		notifyObservers();
	}
	
	public int getKeyMoveUp() {
		return this.keyMoveUp;
	}
	
	public void setKeyMoveUp(int keyMoveUp) {
		this.keyMoveUp = keyMoveUp;
		
		notifyObservers();
	}
	
	public int getKeyMoveDown() {
		return this.keyMoveDown;
	}
	
	public void setKeyMoveDown(int keyMoveDown) {
		this.keyMoveDown = keyMoveDown;
		
		notifyObservers();
	}
	
	public int getKeyPigAttak() {
		return this.keyPigAttak;
	}
	
	public void setKeyPigAttak(int keyPigAttak) {
		this.keyPigAttak = keyPigAttak;
		
		notifyObservers();
	}
	
	@Override
	public void reset() {		
		setTitle("Keyboard Settings");
		
		setKeyStart(KeyEvent.VK_ENTER);
		setKeyPause(KeyEvent.VK_ESCAPE);
		setKeyMoveLeft(KeyEvent.VK_LEFT);
		setKeyMoveRight(KeyEvent.VK_RIGHT);
		setKeyMoveUp(KeyEvent.VK_UP);
		setKeyMoveDown(KeyEvent.VK_DOWN);
		setKeyPigAttak(KeyEvent.VK_SPACE);
	}
}
