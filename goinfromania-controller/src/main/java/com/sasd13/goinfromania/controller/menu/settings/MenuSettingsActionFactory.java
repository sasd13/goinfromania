package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.menu.IMenuActionFactory;

public class MenuSettingsActionFactory implements IMenuActionFactory {

	private Gamepad gamepad;

	public void setGamepad(Gamepad gamepad) {
		this.gamepad = gamepad;
	}

	@Override
	public IAction make(String code) {
		IAction action = null;

		if (EnumMenuSettingsAction.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			action = (MenuSettingsActionGamepad) new MenuSettingsActionGamepad();
			((MenuSettingsActionGamepad) action).setGamepad(gamepad);
		}

		return action;
	}
}
