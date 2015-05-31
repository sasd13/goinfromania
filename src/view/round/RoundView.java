package view.round;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.RoundController;
import game.element.ListElements;
import game.element.character.Pig;
import game.round.Round;

public class RoundView extends JPanel implements Observer, KeyListener {

	private RoundStarterView roundStarterView;
	private RoundResultView roundResultView;
	private RoundStateBarView roundStateBarView;
	private ArenaView arenaView;
	private PigStateView pigStateView;
	
	public RoundView() {
		super(new BorderLayout());
		
		this.roundStarterView = new RoundStarterView();
		this.roundResultView = new RoundResultView();
		
		this.roundStateBarView = new RoundStateBarView();
		add(this.roundStateBarView, BorderLayout.SOUTH);
		
		this.arenaView = new ArenaView();
		this.arenaView.addKeyListener(this);
		this.arenaView.setFocusable(true);
		add(this.arenaView, BorderLayout.CENTER);
		
		this.pigStateView = new PigStateView();
		add(this.pigStateView, BorderLayout.NORTH);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
		this.roundStarterView.update(round, null);
		this.roundResultView.update(round, null);
		this.roundStateBarView.update(round, null);
		
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
	
	public void displayRoundResultView() {
		this.roundResultView.setLocationRelativeTo(this);
		this.roundResultView.setVisible(true);
	}
	
	public void displayRoundStarterView() {
		this.roundStarterView.anime();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		RoundController.actionGamePad(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		RoundController.actionGamePad(e.getKeyCode());
	}
}
