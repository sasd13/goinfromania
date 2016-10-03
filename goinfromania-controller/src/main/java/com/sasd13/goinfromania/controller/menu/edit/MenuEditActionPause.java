package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameHandler;

public class MenuEditActionPause implements IAction {

	private Game game;

	public MenuEditActionPause(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		if (game.getState() == EnumState.RESUMED) {
			GameHandler.pauseGame(game, frame);
		} else {
			GameHandler.resumeGame(game, frame);
		}
	}
}
