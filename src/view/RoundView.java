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
	private RoundMenuView roundMenuView;
	private RoundResultView roundResultView;
	private ArenaView arenaView;
	private PigStateView pigStateView;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		
		this.roundStateView = new RoundStateView();
		add(this.roundStateView, BorderLayout.SOUTH);
		
		this.roundMenuView = new RoundMenuView();
		this.roundResultView = new RoundResultView();
		
		this.arenaView = new ArenaView();
		this.arenaView.addKeyListener(new GamePadListener());
		this.arenaView.setFocusable(true);
		this.arenaView.requestFocusInWindow();
		add(this.arenaView, BorderLayout.CENTER);
		
		this.pigStateView = new PigStateView();
		add(this.pigStateView, BorderLayout.NORTH);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.roundStateView.update(round, null);
		this.roundMenuView.update(round, null);
		this.roundResultView.update(round, null);
		
		ListElements listElements = round.getListElements();
		listElements.addObserver(this.arenaView);
		this.arenaView.update(listElements, null);
		
		if (!listElements.isEmpty()) {
			Pig pig = listElements.getPig();
			pig.addObserver(this.pigStateView);
			this.pigStateView.update(pig, null);
		}
	}
	
	public ArenaView getArenaView() {
		return this.arenaView;
	}
	
	public void displayRoundMenuView() {
		this.roundMenuView.setLocationRelativeTo(this);
		this.roundMenuView.setVisible(true);
	}
	
	public void displayRoundResultView() {
		this.roundResultView.setLocationRelativeTo(this);
		this.roundResultView.setVisible(true);
	}
}
