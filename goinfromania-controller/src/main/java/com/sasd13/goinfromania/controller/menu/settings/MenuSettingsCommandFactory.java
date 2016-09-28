package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.menu.IMenuCommandFactory;

public class MenuSettingsCommandFactory implements IMenuCommandFactory {

	@Override
	public ICommand make(String code) {
		if (EnumMenuSettingsType.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new MenuSettingsGamePadCommand();
		} else {
			return null;
		}
	}
}
