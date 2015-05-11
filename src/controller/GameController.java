package controller;

import javax.swing.JMenu;

import view.GameView;
import view.RoundView;
import db.RoundDAO;
import game.Game;
import game.menu.GameMenuBar;
import game.menu.MenuRound;
import game.menu.MenuSettings;
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
		this.gameView.displayHomeView();
		this.gameView.pack();
		this.gameView.setVisible(true);
	}
	
	public void exit() {
		this.gameView.dispose();
	}
	
	public void showListRounds() {
		loadRounds();
		
		this.gameView.displayListRoundsView();
	}
	
	public void newRound() {
		Round round = new Round();
		round.setRoundNumber(1);
		this.roundController = configRound(round);
		
		this.gameView.displayRoundView();
		this.roundController.start();
	}
	
	public void openRound(String roundId) {
		Round round = this.game.getListRounds().get(roundId);
		this.roundController = configRound(round);
		this.roundController.start();
		
		this.gameView.displayRoundView();
	}
	
	public void closeRound(Round round) {
		if (round.isFinished()) {
			this.game.getListRounds().remove(round);
		}
		
		this.roundController = null;
		
		setMenuEnabled(MenuRound.NAME, false);
		setMenuEnabled(MenuSettings.NAME, true);
		
		this.gameView.displayHomeView();
	}
	
	private RoundController configRound(Round round) {
		this.game.getListRounds().add(round);
		
		RoundView roundView = this.gameView.getRoundView();
		
		setMenuEnabled(MenuRound.NAME, true);
		setMenuEnabled(MenuSettings.NAME, false);
		
		return new RoundController(roundView, round);
	}
	
	private void loadRounds() {
		ListRounds listRounds = RoundDAO.loadAll();
		this.game.setListRounds(listRounds);
	}
	
	private void setMenuEnabled(String menuName, boolean enabled) {
		JMenu menu = ((GameMenuBar) this.gameView.getJMenuBar()).getMenu(menuName);
		menu.setEnabled(enabled);
	}
}
