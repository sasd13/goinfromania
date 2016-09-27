package com.sasd13.goinfromania.controller.menu;

import com.sasd13.goinfromania.controller.menu.edit.MenuEditCommandFactory;
import com.sasd13.goinfromania.controller.menu.file.MenuFileCommandFactory;
import com.sasd13.goinfromania.controller.menu.settings.MenuSettingsCommandFactory;

public class MenuCommandFactory {

	private MenuCommandFactory() {}

	public static IMenuItemCommandFactory make(EnumMenuType menuType) {
		switch (menuType) {
			case FILE:
				return new MenuFileCommandFactory();
			case EDIT:
				return new MenuEditCommandFactory();
			case SETTINGS:
				return new MenuSettingsCommandFactory();
			default:
				return null;
		}
	}
}
