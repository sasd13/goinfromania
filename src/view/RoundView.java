package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import game.element.ListElements;
import game.element.character.Pig;
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
		this.arenaView.addKeyListener(new GamePadListener());
		this.arenaView.setFocusable(true);
		add(this.arenaView, BorderLayout.CENTER);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.roundStateView.update(round, null);
		
		ListElements listElements = round.getListElements();
		listElements.addObserver(this.arenaView);
		this.arenaView.update(listElements, null);
		
		Pig pig = listElements.getPig();
		pig.addObserver(this.pigStateView);
		this.pigStateView.update(pig, null);
	}
	
	public void focusArenaView() {
		this.arenaView.requestFocusInWindow();
	}
	
	public ArenaView getArenaView() {
		return this.arenaView;
	}
}
