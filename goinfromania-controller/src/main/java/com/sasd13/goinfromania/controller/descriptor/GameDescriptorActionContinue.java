package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameHandler;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrameView;

public class GameDescriptorActionContinue implements IAction {

	private Game game;

	public GameDescriptorActionContinue(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrameView frameView) {
		GameHandler.launchGame(game, frameView);
	}
}
