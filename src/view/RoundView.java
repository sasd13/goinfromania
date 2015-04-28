package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import game.round.Round;

public class RoundView extends JPanel implements Observer {
	
	private RoundStateView roundStateView;
	private PigStateView pigStateView;
	private ArenaView arenaView;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		
		this.roundStateView = new RoundStateView();
		add(this.roundStateView, BorderLayout.SOUTH);
		
		this.pigStateView = new PigStateView();
		add(this.pigStateView, BorderLayout.NORTH);
		
		this.arenaView = new ArenaView();
		add(this.arenaView, BorderLayout.CENTER);
	}
	
	public RoundStateView getRoundStateView() {
		return this.roundStateView;
	}
	
	public ArenaView getArenaView() {
		return this.arenaView;
	}
	
	public PigStateView getPigStateView() {
		return this.pigStateView;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.roundStateView.getLabelRoundValue().setText(String.valueOf(round.getId()));
		this.roundStateView.getLabelScoreValue().setText(String.valueOf(round.getScore()));
	}
}
