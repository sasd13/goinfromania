package main.java.view.round;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.java.game.round.Round;
import main.java.game.round.State;
import main.java.game.round.Statistics;
import main.java.view.DimensionConstants;

public class StateBarView extends JPanel implements Observer {

	private JLabel labelRoundNumber, labelRoundState;
	private StatisticsView statisticsView;
	
	public StateBarView() {
		super(new GridLayout(1, 2));
		
		setPreferredSize(new Dimension(DimensionConstants.PANEL_STATE_WIDTH, DimensionConstants.PANEL_STATE_HEIGHT));
		
		JPanel panelRound = new JPanel(new GridLayout(1, 2));
		add(panelRound);
		
		JPanel panelRoundNumber = new JPanel();
		panelRound.add(panelRoundNumber);
		
		panelRoundNumber.add(new JLabel("Partie : "));
		this.labelRoundNumber = new JLabel();
		panelRoundNumber.add(this.labelRoundNumber);
		
		JPanel panelRoundState = new JPanel();
		panelRound.add(panelRoundState);
		
		this.labelRoundState = new JLabel();
		panelRoundState.add(this.labelRoundState);
		
		this.statisticsView = new StatisticsView();
		add(this.statisticsView);
	}

	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.labelRoundNumber.setText(String.valueOf(round.getRoundNumber()));
		if (round.getState() == State.PAUSE) {
			this.labelRoundState.setText(String.valueOf(round.getState()));
		} else {
			this.labelRoundState.setText("");
		}
		
		Statistics statistics = round.getStatistics();
		statistics.addObserver(this.statisticsView);
		this.statisticsView.update(statistics, null);
	}
}
