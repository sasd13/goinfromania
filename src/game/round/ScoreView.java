package game.round;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreView extends JPanel implements Observer {

	private JLabel labelTitle, labelScore;
	
	public ScoreView() {
		super();
		
		setLayout(new GridLayout(1, 2));
		
		this.labelTitle = new JLabel();
		add(this.labelTitle);
		
		this.labelScore = new JLabel();
		add(this.labelScore);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Score score = (Score) observable;
		
		this.labelScore.setText(score.getTitle());
		this.labelScore.setText(String.valueOf(score.getValue()));
	}
}
