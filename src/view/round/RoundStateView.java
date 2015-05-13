package view.round;

import game.round.Round;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.DimensionConstants;

public class RoundStateView extends JPanel implements Observer {

	private JLabel labelRoundValue,
		labelCakesValue,
		labelEnemiesValue,
		labelScoreValue;
	
	public RoundStateView() {
		super(new GridLayout(1, 4));
		
		setPreferredSize(new Dimension(DimensionConstants.PANEL_STATE_WIDTH, DimensionConstants.PANEL_STATE_HEIGHT));
		
		JPanel panelRound = new JPanel();
		add(panelRound);
		
		panelRound.add(new JLabel("Round : "));
		this.labelRoundValue = new JLabel();
		panelRound.add(this.labelRoundValue);
		
		JPanel panelCakes = new JPanel();
		add(panelCakes);
		
		panelCakes.add(new JLabel("Cakes : "));
		this.labelCakesValue = new JLabel();
		panelCakes.add(this.labelCakesValue);
		
		JPanel panelEnemies = new JPanel();
		add(panelEnemies);
		
		panelEnemies.add(new JLabel("Enemies : "));
		this.labelEnemiesValue = new JLabel();
		panelEnemies.add(this.labelEnemiesValue);
		
		JPanel panelScore = new JPanel();
		add(panelScore);
		
		panelScore.add(new JLabel("Score : "));
		this.labelScoreValue = new JLabel();
		panelScore.add(this.labelScoreValue);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRoundValue.setText(String.valueOf(round.getRoundNumber()));
		this.labelCakesValue.setText(round.getCountEatenCakes() + "/" + round.getMaxCountEatenCakes());
		this.labelEnemiesValue.setText(String.valueOf(round.getCountEnemyKilled()));
		this.labelScoreValue.setText(String.valueOf(round.getScore()));
	}
}
