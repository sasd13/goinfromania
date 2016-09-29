package com.sasd13.goinfromania.engine;

import javax.swing.JOptionPane;

import com.sasd13.goinfromania.bean.Game;

public class GameEngine {

	private static class GameEngineHolder {
		private static final GameEngine INSTANCE = new GameEngine();
	}

	public static GameEngine getInstance() {
		return GameEngineHolder.INSTANCE;
	}

	public void requestState(int stateTarget, Game game) {
		new CreateStateProcessor().process(stateTarget, game);
	}

	private void onStop(Game game) {
		String message = "Arr�t de la partie. Sauvegarder la progression ?";

		int selected = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);

		switch (selected) {
			case JOptionPane.YES_OPTION:
				/*
				 * stopGame(); saveGame(); finishGame();
				 */
			case JOptionPane.NO_OPTION:
				/*
				 * stopGame(); finishGame();
				 */
		}
	}
}
