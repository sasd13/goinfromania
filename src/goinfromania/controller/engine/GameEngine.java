package goinfromania.controller.engine;

import java.util.List;

import javax.swing.JOptionPane;

import goinfromania.controller.FrameController;
import goinfromania.db.GameDAO;
import goinfromania.game.Game;
import goinfromania.preferences.SettingPreferencesFactory;
import goinfromania.setting.GamePad;
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
	
	public Game getGame() {
		return game;
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
		if (hasGameInProgress()) {
			return close();
		}
		
		return true;
	}
	
	public boolean hasGameInProgress() {
		return this.game != null;
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
		GamePad gamePad = (GamePad) SettingPreferencesFactory.get("GAMEPAD").pull();
		
		Game game = new Game(gamePad);
		
		open(game);
	}
	
	private void open(Game game) {
		this.game = game;
		this.game.addObserver(this.gameView);
		this.game.addObserver(this.gameView.getArenaView());
		
		this.frameController.displayGame();
		
		start();
	}
	
	private void start() {
		
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
