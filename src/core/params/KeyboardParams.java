package core.params;

import java.awt.event.KeyEvent;

import core.IViewable;
import core.IViewer;

public class KeyboardParams extends Params implements IViewable {

	public static final String NAME = "Keyboard Settings";
	
	private int keyStart;
	private int keyPause;
	private int keyMoveLeft;
	private int keyMoveRight;
	private int keyMoveUp;
	private int keyMoveDown;
	private int keyPigAttak;
	
	public KeyboardParams() {
		super();
		
		setName(NAME);
	}
	
	public int getKeyStart() {
		return this.keyStart;
	}
	
	public void setKeyStart(int keyStart) {
		this.keyStart = keyStart;
	}
	
	public int getKeyPause() {
		return this.keyPause;
	}
	
	public void setKeyPause(int keyPause) {
		this.keyPause = keyPause;
	}
	
	public int getKeyMoveLeft() {
		return this.keyMoveLeft;
	}
	
	public void setKeyMoveLeft(int keyMoveLeft) {
		this.keyMoveLeft = keyMoveLeft;
	}
	
	public int getKeyMoveRight() {
		return this.keyMoveRight;
	}
	
	public void setKeyMoveRight(int keyMoveRight) {
		this.keyMoveRight = keyMoveRight;
	}
	
	public int getKeyMoveUp() {
		return this.keyMoveUp;
	}
	
	public void setKeyMoveUp(int keyMoveUp) {
		this.keyMoveUp = keyMoveUp;
	}
	
	public int getKeyMoveDown() {
		return this.keyMoveDown;
	}
	
	public void setKeyMoveDown(int keyMoveDown) {
		this.keyMoveDown = keyMoveDown;
	}
	
	public int getKeyPigAttak() {
		return this.keyPigAttak;
	}
	
	public void setKeyPigAttak(int keyPigAttak) {
		this.keyPigAttak = keyPigAttak;
	}
	
	@Override
	public void reset() {
		setKeyStart(KeyEvent.VK_ENTER);
		setKeyPause(KeyEvent.VK_ESCAPE);
		setKeyMoveLeft(KeyEvent.VK_LEFT);
		setKeyMoveRight(KeyEvent.VK_RIGHT);
		setKeyMoveUp(KeyEvent.VK_UP);
		setKeyMoveDown(KeyEvent.VK_DOWN);
		setKeyPigAttak(KeyEvent.VK_BACK_SPACE);
	}
	
	@Override
	public IViewer show() {
		KeyboardParamsView keyboardParamsView = new KeyboardParamsView();
		keyboardParamsView.bind(this);
		
		keyboardParamsView.pack();
		keyboardParamsView.setVisible(true);
		
		return keyboardParamsView;
	}
}
