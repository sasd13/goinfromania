package game.element;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class LifeView extends JProgressBar implements Observer {

	private final int LIFE_LOW = 20;
	private final int LIFE_MEDIUM = 50;
	
	public LifeView() {
		super(Life.MIN_VALUE, Life.MAX_VALUE);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Life life = (Life) observable;
		
		setValue(life.getValue());
		if (getValue() >= LIFE_MEDIUM) {
			UIManager.put("ProgressBar.foreground", Color.GREEN);
		} else if (getValue() < LIFE_MEDIUM && getValue() >= LIFE_LOW) {
			UIManager.put("ProgressBar.foreground", Color.ORANGE);
		} else {
			UIManager.put("ProgressBar.foreground", Color.RED);
		}
	}
}
