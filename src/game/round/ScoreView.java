package game.round;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreView extends JPanel implements Observer {

	private JLabel labelScore, labelScoreValue;
	
	public ScoreView() {
		super();
		
		setLayout(new FlowLayout());
		
		this.labelScore = new JLabel("Score : ");
		add(this.labelScore);
		
		this.labelScoreValue = new JLabel();
		add(this.labelScoreValue);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Score score = (Score) observable;
		
		this.labelScoreValue.setText(String.valueOf(score.getValue()));
	}

}
