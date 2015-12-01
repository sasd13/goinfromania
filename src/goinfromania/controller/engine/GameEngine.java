package goinfromania.controller.engine;

import javax.swing.JOptionPane;

import goinfromania.controller.FrameController;
import goinfromania.db.GameDAO;
import goinfromania.game.Game;
import goinfromania.preferences.SettingPreferencesFactory;
import goinfromania.setting.GamePad;

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
			return saveGameAndStop();
		} else {
			stopGameAndDisplayHome();
			
			return true;
		}
	}
	
	public static boolean hasGameInProgress() {
		return game != null;
	}
	
	private static boolean saveGameAndStop() {
		String message = "Sauvegarder la partie ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, "Partie", JOptionPane.YES_NO_CANCEL_OPTION);
		
		switch (selected) {
			case JOptionPane.YES_OPTION:
				saveGame();
				stopGameAndDisplayHome();
				return true;
			case JOptionPane.NO_OPTION:
				stopGameAndDisplayHome();
				return true;
			default:
				return false;
		}
	}
	
	public static void saveGame() {
		GameDAO.update(game);
	}
	
	private static void stopGameAndDisplayHome() {
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
		//TODO
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
	
	public static void pauseGame() {
		//TODO
	}
}
