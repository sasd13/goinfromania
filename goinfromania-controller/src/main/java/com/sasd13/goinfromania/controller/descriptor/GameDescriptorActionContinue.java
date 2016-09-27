package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.IFrame;

public class GameDescriptorActionContinue implements ICommand {

	@Override
	public void execute(IFrame frame) {
		gameEngine.loadGame(game);
	}
}
