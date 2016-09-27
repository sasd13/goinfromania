package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommand;

public class MenuFileOpenCommand implements IMenuItemCommand {

	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void execute() {
		if (gameEngine.stopGameSafely()) {
			gameEngine.openGames();
		}
	}
}
