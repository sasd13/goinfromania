package view.round;

import game.round.Round;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.DimensionConstants;

public class RoundStateView extends JPanel implements Observer {

	private JLabel labelRoundValue,
		labelCakesValue,
		labelScoreValue;
	
	public RoundStateView() {
		super();
		
		setLayout(new GridLayout(1, 2));
		setPreferredSize(new Dimension(DimensionConstants.PANEL_STATE_WIDTH, DimensionConstants.PANEL_STATE_HEIGHT));
		
		JPanel panelRound = new JPanel();
		panelRound.setLayout(new FlowLayout());
		
		panelRound.add(new JLabel("Round : "));
		this.labelRoundValue = new JLabel();
		panelRound.add(this.labelRoundValue);
		
		add(panelRound);
		
		JPanel panelCakes = new JPanel();
		panelCakes.setLayout(new FlowLayout());
		
		panelCakes.add(new JLabel("Cakes : "));
		this.labelCakesValue = new JLabel();
		panelCakes.add(this.labelCakesValue);
		
		add(panelCakes);
		
		JPanel panelScore = new JPanel();
		panelScore.setLayout(new FlowLayout());
		
		panelScore.add(new JLabel("Score : "));
		this.labelScoreValue = new JLabel();
		panelScore.add(this.labelScoreValue);
		
		add(panelScore);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRoundValue.setText(String.valueOf(round.getRoundNumber()));
		this.labelCakesValue.setText(round.getCountEatenCakes() + "/" + round.getMaxCountEatenCakes());
		this.labelScoreValue.setText(String.valueOf(round.getScore()));
	}
}
