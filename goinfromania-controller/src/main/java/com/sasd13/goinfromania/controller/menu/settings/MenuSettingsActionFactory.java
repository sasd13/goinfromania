package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.menu.IMenuActionFactory;

public class MenuSettingsActionFactory implements IMenuActionFactory {

	@Override
	public IAction make(String code) {
		if (EnumMenuSettingsAction.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new MenuSettingsActionGamePad();
		} else {
			return null;
		}
	}
}
