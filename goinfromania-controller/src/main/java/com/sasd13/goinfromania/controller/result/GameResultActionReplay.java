package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialog;
import com.sasd13.goinfromania.controller.IFrame;

public class GameResultActionReplay implements IAction {

	private GameEngine gameEngine = GameEngine.getInstance();
	private IDialog dialog;

	public GameResultActionReplay(IDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void execute(IFrame frame) {
		dialog.close();

		Game game = new Game();

		gameEngine.onCreate(game);
		frame.displayGame(game);
	}
}
