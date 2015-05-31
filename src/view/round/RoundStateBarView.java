package view.round;

import game.round.Round;
import game.round.State;
import game.round.Statistics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.DimensionConstants;

public class RoundStateBarView extends JPanel implements Observer {

	private JLabel labelRoundNumber,
		labelRoundState;
	
	private RoundStatisticsView roundStatisticsView;
	
	public RoundStateBarView() {
		super(new GridLayout(1, 2));
		
		setPreferredSize(new Dimension(DimensionConstants.PANEL_STATE_WIDTH, DimensionConstants.PANEL_STATE_HEIGHT));
		
		JPanel panelRound = new JPanel(new GridLayout(1, 2));
		add(panelRound);
		
		JPanel panelRoundNumber = new JPanel();
		panelRound.add(panelRoundNumber);
		
		panelRoundNumber.add(new JLabel("Round : "));
		this.labelRoundNumber = new JLabel();
		panelRoundNumber.add(this.labelRoundNumber);
		
		JPanel panelRoundState = new JPanel();
		panelRound.add(panelRoundState);
		
		this.labelRoundState = new JLabel();
		panelRoundState.add(this.labelRoundState);
		
		this.roundStatisticsView = new RoundStatisticsView();
		add(this.roundStatisticsView);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRoundNumber.setText(String.valueOf(round.getRoundNumber()));
		if (round.getState() == State.PAUSED) {
			this.labelRoundState.setText(String.valueOf(round.getState()));
		} else {
			this.labelRoundState.setText("");
		}
		
		Statistics statistics = round.getStatistics();
		statistics.addObserver(this.roundStatisticsView);
		this.roundStatisticsView.update(statistics, null);
	}
}
