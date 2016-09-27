package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommand;

public class MenuEditSaveCommand implements IMenuItemCommand {

	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void execute() {
		gameEngine.saveGame();
	}
}