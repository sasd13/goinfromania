package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.FrameHandler;
import com.sasd13.goinfromania.controller.GameHandler;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuFileActionExit implements IAction {

	private Game game;

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrameView frameView) {
		if (game != null && game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			GameHandler.pauseGame(game);
		}

		FrameHandler.closeFrame(frameView, game);
	}
}
