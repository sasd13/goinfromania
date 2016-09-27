package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.ICommandFactory;

public class MenuSettingsCommandFactory implements ICommandFactory {

	@Override
	public ICommand make(String code) {
		if (EnumMenuSettingsType.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new MenuSettingsGamePadCommand();
		} else {
			return null;
		}
	}
}
