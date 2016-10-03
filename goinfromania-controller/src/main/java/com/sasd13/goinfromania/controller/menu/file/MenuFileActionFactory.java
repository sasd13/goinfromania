package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;

public class MenuFileActionFactory {

	private Game game;

	public void setGame(Game game) {
		this.game = game;
	}

	public IAction make(String code) {
		IAction action = null;

		if (EnumMenuFileAction.NEW.getCode().equalsIgnoreCase(code)) {
			action = (MenuFileActionNew) new MenuFileActionNew();
			((MenuFileActionNew) action).setGame(game);
		} else if (EnumMenuFileAction.OPEN.getCode().equalsIgnoreCase(code)) {
			action = (MenuFileActionOpen) new MenuFileActionOpen();
			((MenuFileActionOpen) action).setGame(game);
		} else if (EnumMenuFileAction.EXIT.getCode().equalsIgnoreCase(code)) {
			action = (MenuFileActionExit) new MenuFileActionExit();
			((MenuFileActionExit) action).setGame(game);
		}

		return action;
	}
}
