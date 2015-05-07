package view;

import game.round.Round;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundStateView extends JPanel implements Observer {

	private JLabel labelRound,
		labelRoundValue,
		labelScore,
		labelScoreValue;
	
	public RoundStateView() {
		super();
		
		setLayout(new GridLayout(1, 2));
		
		JPanel panelRound = new JPanel();
		panelRound.setLayout(new FlowLayout());
		
		this.labelRound = new JLabel("Round : ");
		panelRound.add(this.labelRound);
		this.labelRoundValue = new JLabel();
		panelRound.add(this.labelRoundValue);
		
		add(panelRound);
		
		JPanel panelScore = new JPanel();
		panelRound.setLayout(new FlowLayout());
		
		this.labelScore = new JLabel("Score : ");
		panelScore.add(this.labelScore);
		this.labelScoreValue = new JLabel();
		panelScore.add(this.labelScoreValue);
		
		add(panelScore);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRoundValue.setText(String.valueOf(round.getRoundNumber()));
		this.labelScoreValue.setText(String.valueOf(round.getScore()));
	}
}
