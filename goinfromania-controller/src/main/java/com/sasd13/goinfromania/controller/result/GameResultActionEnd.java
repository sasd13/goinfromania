package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialog;
import com.sasd13.goinfromania.controller.IFrame;

public class GameResultActionEnd implements IAction {

	private GameEngine gameEngine = GameEngine.getInstance();
	private IDialog dialog;
	
	public GameResultActionEnd(IDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void execute(IFrame frame) {
		dialog.close();
		gameEngine.finishGame();
		frame.displayHome();
	}
}
