package main.java.engine;

import javax.swing.JOptionPane;

import main.java.bean.Game;
import main.java.bean.State;
import main.java.bean.setting.GamePad;
import main.java.controller.FrameController;
import main.java.db.GameDAO;
import main.java.preferences.SettingPreferencesFactory;

public class GameEngine {
	
	private static Game game;
	private static GamePad gamePad;
	
	private static FrameController frameController;
	
	public static Game getGame() {
		return game;
	}
	
	public static GamePad getGamePad() {
		return gamePad;
	}
	
	public static void setFrameController(FrameController frameController) {
		GameEngine.frameController = frameController;
	}
	
	public static boolean stopGameSafely() {
		if (hasGameInProgress()) {
			return confirmStopGame();
		}
		
		return true;
	}
	
	public static boolean hasGameInProgress() {
		return game != null;
	}
	
	private static boolean confirmStopGame() {
		String message = "Arrêt de la partie. Sauvegarder la progression ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, "Partie", JOptionPane.YES_NO_CANCEL_OPTION);
		
		switch (selected) {
			case JOptionPane.YES_OPTION:
				stopGame();
				saveGame();
				finishGameAndDisplayHome();
				return true;
			case JOptionPane.NO_OPTION:
				stopGame();
				finishGameAndDisplayHome();
				return true;
			default:
				return false;
		}
	}
	
	private static void stopGame() {
		game.setState(State.STOPPED);
	}
	
	public static void saveGame() {
		GameDAO.update(game);
	}
	
	public static void finishGameAndDisplayHome() {
		game.deleteObservers();
		game = null;
		
		frameController.displayHome();
	}
	
	public static void newGame() {		
		openGame(new Game());
	}
	
	public static void openGame(Game game) {
		GameEngine.game = game;
		
		gamePad = (GamePad) SettingPreferencesFactory.get("GAMEPAD").pull();
		
		frameController.displayGame(game);
		
		startGame();
	}
	
	private static void startGame() {
		game.setState(State.STARTED);
	}
	
	public static void listGames() {
		frameController.displayListGames();
	}
	
	public static void exitGame() {
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, Game.NAME, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void pauseOrResumeGame() {
		switch (game.getState()) {
			case STARTED:
				pauseGame();
				break;
			case PAUSED:
				startGame();
				break;
			default:
				//TODO Throw exception
				break;
		}
	}
	
	private static void pauseGame() {
		game.setState(State.PAUSED);
	}
}
