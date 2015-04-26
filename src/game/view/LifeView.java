package game.view;

import game.element.character.Life;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

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
	}
}
