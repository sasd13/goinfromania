package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class MenuFileOpenCommand implements ICommand {

	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void execute(IFrame frame) {
		if (gameEngine.stopGameSafely()) {
			frame.displayGames(GameDAO.loadAll());
		}
	}
}
