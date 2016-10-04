package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;

public class GameDescriptorActionFactory {

	private GameDescriptorActionFactory() {
	}

	public static IAction make(String code, IDescriptorView descriptorView, Game game) {
		if (EnumGameDescriptorAction.CONTINUE.getCode().equalsIgnoreCase(code)) {
			return new GameDescriptorActionContinue(game);
		} else if (EnumGameDescriptorAction.DELETE.getCode().equalsIgnoreCase(code)) {
			return new GameDescriptorActionDelete(descriptorView, game);
		} else {
			return null;
		}
	}
}
