package goinfromania.controller.engine;

import javax.swing.JOptionPane;

import goinfromania.controller.FrameController;
import goinfromania.db.GameDAO;
import goinfromania.game.Game;
import goinfromania.preferences.SettingPreferencesFactory;
import goinfromania.setting.GamePad;

public class GameEngine {
	
	private static Game game;
	
	private static FrameController frameController;
	
	public static Game getGame() {
		return game;
	}
	
	public static void setFrameController(FrameController frameController) {
		GameEngine.frameController = frameController;
	}
	
	public static boolean closeIfHasGameInProgress() {
		if (hasGameInProgress()) {
			return close();
		}
		
		return true;
	}
	
	public static boolean hasGameInProgress() {
		return game != null;
	}
	
	private static boolean close() {
		String message = "Sauvegarder la partie ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, "Partie", JOptionPane.YES_NO_CANCEL_OPTION);
		
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
	
	private static void performSave() {
		GameDAO.update(game);
	}
	
	private static void performClose() {
		game.deleteObservers();
		game = null;
		
		frameController.displayHome();
	}
	
	public static void actionNew() {
		GamePad gamePad = (GamePad) SettingPreferencesFactory.get("GAMEPAD").pull();
		
		Game game = new Game(gamePad);
		
		open(game);
	}
	
	private static void open(Game game) {
		GameEngine.game = game;
		
		frameController.displayGame(game);
		
		start();
	}
	
	private static void start() {
		
	}
	
	public static void actionList() {
		frameController.displayListGames();
	}
	
	public static void actionExit() {
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, Game.NAME, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void actionPause() {
		//TODO
	}
	
	public static void actionStop() {
		if (closeIfHasGameInProgress()) {
			frameController.displayHome();
		}
	}
	
	public static void actionSave() {
		performSave();
	}
	
	public static void actionContinue(Game game) {
		open(game);
	}
	
	public static void actionDelete(Game game) {
		GameDAO.delete(game);
		
		actionList();
	}
}
