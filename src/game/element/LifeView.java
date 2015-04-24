package game.element;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class LifeView extends JPanel implements Observer {
	
	private JLabel labelLife;
	private JProgressBar progressBarLifeValue;
	
	public LifeView() {
		super();
		
		setLayout(new FlowLayout());
		
		this.labelLife = new JLabel("Life : ");
		add(this.labelLife);
		
		this.progressBarLifeValue = new JProgressBar(Life.LIFE_MIN, Life.LIFE_MAX);
		add(this.progressBarLifeValue);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Life life = (Life) observable;
		
		this.progressBarLifeValue.setValue(life.getValue());
		
		if (life.getValue() >= Life.LIFE_MEDIUM) {
			UIManager.put("ProgressBar.foreground", Color.GREEN);
		} else if (life.getValue() < Life.LIFE_MEDIUM && life.getValue() >= Life.LIFE_LOW) {
			UIManager.put("ProgressBar.foreground", Color.ORANGE);
		} else {
			UIManager.put("ProgressBar.foreground", Color.RED);
		}
	}
}
