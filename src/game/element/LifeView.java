package game.element;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class LifeView extends JPanel implements Observer {
	
	private JLabel labelTitle;
	private JProgressBar progressBarLife;
	
	public LifeView() {
		super();
		
		this.labelTitle = new JLabel();
		
		this.progressBarLife = new JProgressBar(Life.MIN_VALUE, Life.MAX_VALUE);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Life life = (Life) observable;
		
		this.labelTitle.setText(life.getTitle());
		
		this.progressBarLife.setValue(life.getValue());
		if (life.getValue() >= Life.LIFE_MEDIUM) {
			UIManager.put("ProgressBar.foreground", Color.GREEN);
		} else if (life.getValue() < Life.LIFE_MEDIUM && life.getValue() >= Life.LIFE_LOW) {
			UIManager.put("ProgressBar.foreground", Color.ORANGE);
		} else {
			UIManager.put("ProgressBar.foreground", Color.RED);
		}
	}
}
