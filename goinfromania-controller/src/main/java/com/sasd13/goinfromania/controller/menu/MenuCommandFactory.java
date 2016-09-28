package com.sasd13.goinfromania.controller.menu;

import com.sasd13.goinfromania.controller.menu.edit.MenuEditCommandFactory;
import com.sasd13.goinfromania.controller.menu.file.MenuFileCommandFactory;
import com.sasd13.goinfromania.controller.menu.settings.MenuSettingsCommandFactory;

public class MenuCommandFactory {

	private MenuCommandFactory() {}

	public static IMenuCommandFactory make(String code) {
		if (EnumMenuType.FILE.getCode().equalsIgnoreCase(code)) {
			return new MenuFileCommandFactory();
		} else if (EnumMenuType.EDIT.getCode().equalsIgnoreCase(code)) {
			return new MenuEditCommandFactory();
		} else if (EnumMenuType.SETTINGS.getCode().equalsIgnoreCase(code)) {
			return new MenuSettingsCommandFactory();
		} else {
			return null;
		}
	}
}
