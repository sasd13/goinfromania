package com.sasd13.goinfromania.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.IElement;
import com.sasd13.goinfromania.bean.State;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.bean.setting.GamePad;
import com.sasd13.goinfromania.dao.GameDAO;
import com.sasd13.goinfromania.util.GameConstants;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class GameEngine {
	
	private Game game;
	private GamePad gamePad;
	
	private static class GameEngineHolder {
		private static final GameEngine INSTANCE = new GameEngine();
	}
	
	public static GameEngine getInstance() {
		return GameEngineHolder.INSTANCE;
	}
	
	public Game getGame() {
		return game;
	}
	
	public GamePad getGamePad() {
		return gamePad;
	}
	
	public boolean stopGameSafely() {
		if (hasGameInProgress()) {
			return confirmStopGame();
		}
		
		return true;
	}
	
	public boolean hasGameInProgress() {
		return game != null;
	}
	
	private boolean confirmStopGame() {
		String message = "Arr�t de la partie. Sauvegarder la progression ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		
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
	
	private void stopGame() {
		game.setState(State.STOPPED);
	}
	
	public void saveGame() {
		GameDAO.update(game);
	}
	
	public void finishGameAndDisplayHome() {
		game.deleteObservers();
		game = null;
	}
	
	public void newGame() {	
		Game game = new Game();
		
		addPigToGame(game);
		
		openGame(game);
	}

	private void addPigToGame(Game game) {
		Pig pig = new Pig();
		pig.setLife(GameConstants.PIG_LIFE);
		
		game.addElement(pig);
	}
	
	public void openGame(Game game) {
		this.game = game;
		
		gamePad = (GamePad) SettingPreferencesFactory.make("GAMEPAD").pull();
		
		startGame();
	}
	
	private void startGame() {
		game.setState(State.STARTED);
	}
	
	public void exitGame() {
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void pauseOrResumeGame() {
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
	
	private void pauseGame() {
		game.setState(State.PAUSED);
	}
	
	public Pig findPig(List<IElement> elements) {
		for (IElement element : elements) {
			if (element instanceof Pig) {
				return (Pig) element;
			}
		}
		
		return null;
	}
}
