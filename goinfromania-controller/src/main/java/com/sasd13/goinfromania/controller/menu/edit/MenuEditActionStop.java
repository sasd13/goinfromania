package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;

public class MenuEditActionStop implements IAction {

	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void execute(IFrame frame) {
		gameEngine.stopGameSafely();
	}
}
