package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialog;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameEngine;

public class GameResultActionReplay implements IAction {

	private IDialog dialog;
	private Game game;

	public GameResultActionReplay(IDialog dialog, Game game) {
		this.dialog = dialog;
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		dialog.close();
		GameEngine.getInstance().onDestroy(game);
		
		Game newGame = Game.clone(game);
		
		GameEngine.getInstance().onCreate(newGame);
		frame.displayGame(newGame);
	}
}
