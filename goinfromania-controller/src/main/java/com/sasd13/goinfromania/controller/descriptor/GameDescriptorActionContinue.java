package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameEngine;

public class GameDescriptorActionContinue implements IAction {

	private Game game;

	public GameDescriptorActionContinue(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		GameEngine.getInstance().requestState(EnumState.RESUMED.getOrder(), game);
	}
}
