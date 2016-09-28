package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.IFrame;

public class GameResultEndCommand implements ICommand {

	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void execute(IFrame frame) {
		// this.gameDialogResult.dispose();

		gameEngine.finishGameAndDisplayHome();
		// FrameController.displayHome();
	}
}
