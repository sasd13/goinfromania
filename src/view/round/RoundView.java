package view.round;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.element.ListElements;
import game.element.character.Pig;
import game.round.Round;

public class RoundView extends JPanel implements Observer {

	private RoundMenuView roundMenuView;
	private RoundResultView roundResultView;
	private RoundStateView roundStateView;
	private ArenaView arenaView;
	private PigStateView pigStateView;
	
	private RoundStartView roundStartView;
	
	public RoundView() {
		super();
		
		setLayout(new BorderLayout());
		
		this.roundMenuView = new RoundMenuView();
		this.roundResultView = new RoundResultView();
		
		this.roundStateView = new RoundStateView();
		add(this.roundStateView, BorderLayout.SOUTH);
		
		this.arenaView = new ArenaView();
		this.arenaView.addKeyListener(new GamePadListener());
		this.arenaView.setFocusable(true);
		this.arenaView.requestFocusInWindow();
		add(this.arenaView, BorderLayout.CENTER);
		
		this.pigStateView = new PigStateView();
		add(this.pigStateView, BorderLayout.NORTH);
		
		this.roundStartView = new RoundStartView();
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Round round = (Round) observable;
		
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
		
		this.roundStartView.update(round, null);
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
	
	public void showStartRoundMessageWithRules(boolean showRules) {
		if (showRules) {
			String title = "Rules";
			String message = "Eat cakes to succeed! Be careful from enemies and bad foods...";
			
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.OK_OPTION);
			this.roundStartView.anime();
		} else {
			this.roundStartView.anime();
		}
	}
}
