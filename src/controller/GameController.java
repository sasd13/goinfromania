package controller;

import view.GameView;
import view.RoundView;
import db.RoundDAO;
import game.Game;
import game.menu.GameMenu;
import game.round.ListRounds;
import game.round.Round;

public class GameController {

	private static GameController instance = null;
	
	private Game game;
	private GameView gameView;
	
	private RoundController roundController;
	
	private GameController() {
		this.game = Game.getInstance();
		this.gameView = GameView.getInstance();
		
		this.game.addObserver(this.gameView);
		
		this.roundController = null;
	}
	
	public static synchronized GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		
		return instance;
	}
	
	public void play() {
		showListRounds();
		
		this.gameView.pack();
		this.gameView.setVisible(true);
	}
	
	public void exit() {
		saveRounds();
		
		this.gameView.dispose();
	}
	
	public RoundController getRoundController() {
		return this.roundController;
	}
	
	private void loadRounds() {
		ListRounds listRounds = RoundDAO.loadAll();
		this.game.setListRound(listRounds);
	}
	
	private void saveRounds() {
		ListRounds listRounds = this.game.getListRound();
		RoundDAO.saveAll(listRounds);
	}
	
	public void showListRounds() {
		loadRounds();
		
		this.gameView.displayListRoundsView();
	}
	
	public void newRound() {
		Round round = new Round(1);
		this.roundController = configRound(round);
		
		this.gameView.displayLiveRoundView();
		this.roundController.start();
	}
	
	public void openRound(String roundId) {
		Round round = this.game.getListRound().get(roundId);
		this.roundController = configRound(round);
		
		this.gameView.displayLiveRoundView();
		this.roundController.start();
	}
	
	public void closeRound(Round round) {
		if (round.isFinished()) {
			this.game.getListRound().remove(round);
		}
		
		showListRounds();
	}
	
	private RoundController configRound(Round round) {
		RoundController roundController = null;
		
		this.game.getListRound().add(round);
		
		RoundView roundView = new RoundView();		
		roundController = new RoundController(round, roundView);
		
		this.gameView.setLiveRoundView(roundView);
		((GameMenu) this.gameView.getJMenuBar()).getMenuRound().setEnabled(true);
		
		return roundController;
	}
}
