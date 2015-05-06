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
	
	public void play() {
		showListRounds();
		
		this.gameView.pack();
		this.gameView.setVisible(true);
	}
	
	public void exit() {
		saveRounds();
		
		this.gameView.dispose();
	}
	
	public void showListRounds() {
		loadRounds();
		
		this.gameView.displayListRoundsView();
	}
	
	public void newRound() {
		Round round = new Round();
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
		
		this.roundController = null;
		
		((GameMenu) this.gameView.getJMenuBar()).getMenuRound().setEnabled(false);
		
		showListRounds();
	}
	
	private RoundController configRound(Round round) {
		this.game.getListRound().add(round);
		
		RoundView roundView = new RoundView();
		this.gameView.setLiveRoundView(roundView);
		
		((GameMenu) this.gameView.getJMenuBar()).getMenuRound().setEnabled(true);
		
		return new RoundController(roundView, round);
	}
	
	private void loadRounds() {
		ListRounds listRounds = RoundDAO.loadAll();
		this.game.setListRound(listRounds);
	}
	
	private void saveRounds() {
		ListRounds listRounds = this.game.getListRound();
		RoundDAO.saveAll(listRounds);
	}
}
