package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.controller.menu.IMenuItemCommand;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommandFactory;

public class MenuSettingsCommandFactory implements IMenuItemCommandFactory {

	@Override
	public IMenuItemCommand make(String code) {
		if (EnumMenuSettingsType.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new MenuSettingsGamePadCommand();
		} else {
			return null;
		}
	}
}
