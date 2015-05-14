package controller;

import java.time.ZonedDateTime;

import javax.swing.JOptionPane;

import view.GameView;
import view.round.RoundView;
import db.RoundDAO;
import game.Game;
import game.menu.GameMenuBar;
import game.round.ListRounds;
import game.round.Round;

public class GameController {

	private static GameController instance = null;
	
	private GameView gameView;
	private Game game;
	
	private RoundController roundController;
	
	private GameController() {
		this.gameView = GameView.getInstance();
		this.game = Game.getInstance();
		this.game.addObserver(this.gameView);
		this.gameView.update(this.game, null);
		
		this.roundController = null;
	}
	
	public static synchronized GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		
		return instance;
	}
	
	public RoundController getRoundController() {
		return this.roundController;
	}
	
	public void startGame() {
		ListRounds listRounds = RoundDAO.loadAll();
		this.game.setListRounds(listRounds);
		
		displayHome();
		
		this.gameView.pack();
		//To center the frame on screen, must be called after pack()
		this.gameView.setLocationRelativeTo(null);
		this.gameView.setVisible(true);
	}
	
	public void showDialogConfirmExitGame() {
		String title = Game.NAME;
		String message = "Confirm exit game ?";
		
		int selected = JOptionPane.showConfirmDialog(this.gameView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			exitGame();
		}
	}
	
	private void exitGame() {
		if (this.roundController != null && !this.roundController.isRoundStopped()) {
			this.roundController.showDialogConfirmSaveRound();
		}
		
		this.game.deleteObservers();
		this.gameView.dispose();
	}
	
	public boolean stopRoundIfStarted() {
		if (this.roundController == null || this.roundController.isRoundStopped()) {
			return true;
		}
		
		this.roundController.showDialogConfirmStopRound();
		
		return this.roundController.isRoundStopped();
	}
	
	public void displayHome() {
		this.gameView.displayHomeView();
	}
	
	public void displayRound() {
		this.gameView.displayRoundView();
	}
	
	public void displayListRounds() {
		this.gameView.displayListRoundsView();
	}
	
	public void displayListScores() {
		this.gameView.displayListScoresView();
	}
	
	public void newRound() {
		Round round = Round.getNewInstance();
		
		openRound(round);
	}
	
	public void openRound(Round round) {
		RoundView roundView = this.gameView.getRoundView();
		this.roundController = new RoundController(roundView, round);	
		
		setMenuRoundEnabled(true);
		displayRound();
		
		if (round.getRoundNumber() == 1) {
			this.roundController.showDialogRoundRules();
		}
		this.roundController.displayRoundStarter();
		this.roundController.startRound();
	}
	
	public void setMenuRoundEnabled(boolean enabled) {
		((GameMenuBar) this.gameView.getJMenuBar()).setMenuRoundEnabled(enabled);
	}
	
	public void saveRound(Round round) {
		round.setUpdatedAt(ZonedDateTime.now());
		this.game.getListRounds().add(round);
		RoundDAO.save(round);
	}
	
	public void removeRound(Round round) {
		this.game.getListRounds().remove(round);
		RoundDAO.remove(round);
	}
}
