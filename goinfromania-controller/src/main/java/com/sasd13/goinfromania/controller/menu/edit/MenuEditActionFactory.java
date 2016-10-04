package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;

public class MenuEditActionFactory {

	private MenuEditActionFactory() {
	}

	public static IAction make(String code, Game game) {
		if (EnumMenuEditAction.STOP.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionStop(game);
		} else if (EnumMenuEditAction.SAVE.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionSave(game);
		} else {
			return null;
		}
	}
}
