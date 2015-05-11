package controller;

import view.GameView;
import view.RoundView;
import db.RoundDAO;
import game.Game;
import game.menu.GameMenuBar;
import game.round.Level;
import game.round.ListRounds;
import game.round.Round;
import game.round.RoundFactory;

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
	
	public void playGame() {
		loadRounds();
		this.gameView.displayHomeView();
		
		this.gameView.pack();
		this.gameView.setVisible(true);
	}
	
	public void exitGame() {
		this.gameView.dispose();
	}
	
	public void displayHome() {
		this.gameView.displayHomeView();
	}
	
	public void displayListRounds() {
		this.gameView.displayListRoundsView();
	}
	
	public void displayListScores() {
		this.gameView.displayListScoresView();
	}
	
	public void displayRound() {
		this.gameView.displayRoundView();
	}
	
	public void newRound() {
		Round round = RoundFactory.createNewRound(Level.EASY);
		round.setRoundNumber(1);
		
		openRound(round);
	}
	
	private void openRound(Round round) {
		this.game.getListRounds().add(round);
		
		this.roundController = createRoundController(round);		
		
		setMenuRoundEnabled(true);
		displayRound();
		
		this.roundController.startRound();
	}
	
	public void nextRound(Round round) {
		this.game.getListRounds().remove(round);
		
		Round nextRound = RoundFactory.createNextRound(round, false, true);
		
		openRound(nextRound);
	}
	
	public void closeRound(Round round) {
		if (round.isFinished()) {
			this.game.getListRounds().remove(round);
		}
		
		this.roundController = null;
		
		setMenuRoundEnabled(false);
		displayHome();
	}
	
	public void closeRoundIfInProgress() {
		if (this.roundController != null) {
			this.roundController.stopRound();
		}
	}
	
	private RoundController createRoundController(Round round) {		
		RoundView roundView = this.gameView.getRoundView();
		RoundController roundController = new RoundController(roundView, round);
		
		return roundController;
	}
	
	private void loadRounds() {
		ListRounds listRounds = RoundDAO.loadAll();
		this.game.setListRounds(listRounds);
	}
	
	private void setMenuRoundEnabled(boolean enabled) {
		((GameMenuBar) this.gameView.getJMenuBar()).setMenuRoundEnabled(enabled);
	}
}
