package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.menu.IMenuActionFactory;

public class MenuEditActionFactory implements IMenuActionFactory {

	private Game game;

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public IAction make(String code) {
		if (EnumMenuEditAction.PAUSE.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionPause(game);
		} else if (EnumMenuEditAction.STOP.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionStop(game);
		} else if (EnumMenuEditAction.SAVE.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionSave(game);
		} else {
			return null;
		}
	}
}
