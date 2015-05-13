package view.round;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controller.GameController;
import controller.RoundController;
import game.element.ListElements;
import game.element.character.Pig;
import game.round.Round;

public class RoundView extends JPanel implements Observer, KeyListener {

	private RoundStartView roundStartView;
	private RoundMenuView roundMenuView;
	private RoundResultView roundResultView;
	private RoundStateView roundStateView;
	private ArenaView arenaView;
	private PigStateView pigStateView;
	
	public RoundView() {
		super(new BorderLayout());
		
		this.roundStartView = new RoundStartView();
		this.roundMenuView = new RoundMenuView();
		this.roundResultView = new RoundResultView();
		
		this.roundStateView = new RoundStateView();
		add(this.roundStateView, BorderLayout.SOUTH);
		
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
		
		this.roundStartView.update(round, null);
		this.roundMenuView.update(round, null);
		this.roundResultView.update(round, null);
		this.roundStateView.update(round, null);
		
		ListElements listElements = round.getListElements();
		listElements.addObserver(this.arenaView);
		this.arenaView.update(listElements, null);
		
		if (!listElements.isEmpty()) {
			Pig pig = listElements.getPig();
			pig.addObserver(this.pigStateView);
			this.pigStateView.update(pig, null);
		}
	}
	
	public void updateArenaView() {
		this.arenaView.repaint();
	}
	
	public void requestFocusOnArenaView() {
		this.arenaView.requestFocusInWindow();
	}
	
	public void displayRoundMenuView() {
		this.roundMenuView.setLocationRelativeTo(this);
		this.roundMenuView.setVisible(true);
	}
	
	public void displayRoundResultView() {
		this.roundResultView.setLocationRelativeTo(this);
		this.roundResultView.setVisible(true);
	}
	
	public void displayRoundStartView() {
		this.roundStartView.anime();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		RoundController roundController = GameController.getInstance().getRoundController();
		roundController.actionGamePad(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		RoundController roundController = GameController.getInstance().getRoundController();
		roundController.actionGamePad(e.getKeyCode());
	}
}
