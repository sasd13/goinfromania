package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.IFrame;

public class GameDescriptorActionContinue implements ICommand {

	private GameEngine gameEngine = GameEngine.getInstance();
	private IDescriptor descriptor;

	public GameDescriptorActionContinue(IDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public void execute(IFrame frame) {
		Game game = descriptor.getDescriptable();

		gameEngine.startGame(game);
		frame.displayGame(game);
	}
}
