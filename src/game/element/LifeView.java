package game.element;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LifeView extends JPanel implements Observer {
	
	private JLabel labelTitle;
	private JLabel labelLife;
	
	public LifeView() {
		super();
		
		setLayout(new GridLayout(1, 2));
		
		this.labelTitle = new JLabel();
		add(this.labelTitle);
		
		this.labelLife = new JLabel();
		add(this.labelLife);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Life life = (Life) observable;
		
		this.labelTitle.setText(life.getTitle() + " :");
		this.labelLife.setText(String.valueOf(life.getValue()));
	}
}
