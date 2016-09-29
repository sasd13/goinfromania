package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameEngine;
import com.sasd13.goinfromania.engine.State;

public class MenuFileActionExit implements IAction {

	@Override
	public void execute(IFrame frame) {
		GameEngine gameEngine = GameEngine.getInstance();
		
		if (gameEngine.getState().ordinal() < State.STOPPED.ordinal()) {
			gameEngine.onP
		}
	}
}
