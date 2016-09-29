package com.sasd13.goinfromania.controller;

import javax.swing.JOptionPane;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.GamePad;
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

	public void onCreate(Game game) {
		this.game = game;

		gamePad = (GamePad) SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode()).pull();
	}

	public void onStart() {

	}

	public void onResume() {

	}

	public void onPause() {

	}

	public void onStop() {
		if (hasGameInProgress()) {
			String message = "Arr�t de la partie. Sauvegarder la progression ?";

			int selected = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

			switch (selected) {
				case JOptionPane.YES_OPTION:
					/*stopGame();
					saveGame();
					finishGame();*/
				case JOptionPane.NO_OPTION:
					/*stopGame();
					finishGame();*/
			}
		}
	}

	public void onDestroy() {
		game.deleteObservers();
		game = null;
	}

	public boolean hasGameInProgress() {
		return game != null;
	}
	
	public boolean isGamePaused() {
		return true;
	}
}
