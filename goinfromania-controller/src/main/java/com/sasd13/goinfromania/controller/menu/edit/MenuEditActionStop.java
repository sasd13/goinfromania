package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameEngine;

public class MenuEditActionStop implements IAction {

	private Game game;

	public MenuEditActionStop(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		GameEngine.getInstance().onStop(game);
		//TODO : display stop
	}
}
