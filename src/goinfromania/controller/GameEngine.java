package goinfromania.controller;

import java.util.List;

import javax.swing.JOptionPane;

import goinfromania.db.GameDAO;
import goinfromania.game.Game;
import goinfromania.game.Player;
import goinfromania.view.frame.GameView;
import goinfromania.view.frame.ListGamesView;

public class GameEngine {
	
	private static GameEngine instance = null;
	
	private Game game;
	
	private GameView gameView;
	private ListGamesView listGamesView;
	
	private FrameController frameController;
	
	private GameEngine() {}
	
	public static synchronized GameEngine getInstance() {
		if (instance == null) {
			instance = new GameEngine();
		}
		
		return instance;
	}
	
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	public void setListGamesView(ListGamesView listGamesView) {
		this.listGamesView = listGamesView;
	}
	
	public void setFrameController(FrameController frameController) {
		this.frameController = frameController;
	}
	
	public boolean closeIfHasGameInProgress() {
		if (this.game != null) {
			return close();
		}
		
		return true;
	}
	
	private boolean close() {
		String message = "Sauvegarder la partie ?";
		
		int selected = JOptionPane.showConfirmDialog(this.gameView, message, "Partie", JOptionPane.YES_NO_CANCEL_OPTION);
		
		switch (selected) {
			case JOptionPane.YES_OPTION:
				performSave();
				performClose();
				return true;
			case JOptionPane.NO_OPTION:
				performClose();
				return true;
			default:
				return false;
		}
	}
	
	private void performSave() {
		GameDAO.update(this.game);
	}
	
	private void performClose() {
		this.game.deleteObservers();
		this.game = null;
		
		this.frameController.displayHome();
	}
	
	public void actionNew() {
		Game game = new Game();
		
		setPlayer(game);
		open(game);
	}

	private void setPlayer(Game game) {
		Player player = new Player();
		game.setPlayer(player);
	}
	
	private void open(Game game) {
		this.game = game;
		this.game.addObserver(this.gameView);
		
		this.gameView.update(this.game, null);
		
		this.frameController.displayGame();
	}
	
	public void actionList() {
		List<Game> games = GameDAO.loadAll();
		
		this.listGamesView.setGames(games);
		
		this.frameController.displayListGames();
	}
	
	public void actionExit() {
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, Game.NAME, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void actionPause() {
		//TODO
	}
	
	public void actionStop() {
		if (closeIfHasGameInProgress()) {
			this.frameController.displayHome();
		}
	}
	
	public void actionSave() {
		performSave();
	}
	
	public void actionContinue(Game game) {
		open(game);
	}
	
	public void actionDelete(Game game) {
		GameDAO.delete(game);
		
		actionList();
	}
}
