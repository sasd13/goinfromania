package controller;

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
		loadListRounds();
		
		this.gameView.displayHomeView();
		this.gameView.pack();
		this.gameView.setVisible(true);
	}
	
	private void loadListRounds() {
		ListRounds listRounds = RoundDAO.loadAll();
		this.game.setListRounds(listRounds);
	}
	
	public void exitGame() {
		this.game.deleteObservers();
		this.gameView.dispose();
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
			this.roundController.showRoundRulesMessage();
		}
		this.roundController.displayRoundStart();
		this.roundController.startRound();
	}
	
	public void setMenuRoundEnabled(boolean enabled) {
		((GameMenuBar) this.gameView.getJMenuBar()).setMenuRoundEnabled(enabled);
	}
	
	public void nextRound(Round round) {
		round = Round.createNextRound(round, false, true);
		
		openRound(round);
	}
	
	public void saveRound(Round round) {
		this.game.getListRounds().add(round);
		RoundDAO.save(round);
	}
	
	public void removeRound(Round round) {
		this.game.getListRounds().remove(round);
		RoundDAO.remove(round);
	}
	
	public boolean stopRoundIfStarted() {
		if (this.roundController != null && !this.roundController.isRoundStopped()) {
			return this.roundController.showStopRoundMessage();
		}
		
		return true;
	}
}
