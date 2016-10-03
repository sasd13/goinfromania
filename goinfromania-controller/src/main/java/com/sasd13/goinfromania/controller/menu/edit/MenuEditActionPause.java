package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameHandler;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuEditActionPause implements IAction {

	private Game game;

	public MenuEditActionPause(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrameView frameView) {
		if (game.getState() == EnumState.RESUMED) {
			GameHandler.pauseGame(game);
		} else {
			GameHandler.resumeGame(game);
		}
	}
}
