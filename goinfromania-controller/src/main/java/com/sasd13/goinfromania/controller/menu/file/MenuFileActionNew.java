package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;

public class MenuFileActionNew implements IAction {

	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void execute(IFrame frame) {
		if (gameEngine.stopGameSafely()) {
			Game game = new Game();

			frame.displayGame(game);
			gameEngine.onCreate(game);
		}
	}
}
