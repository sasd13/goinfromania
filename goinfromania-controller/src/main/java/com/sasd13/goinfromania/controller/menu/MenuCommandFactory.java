package com.sasd13.goinfromania.controller.menu;

public class MenuCommandFactory {

	private MenuCommandFactory() {}
	
	public static IMenuItemCommandFactory make(EnumMenuType menuType) {
		switch (menuType) {
			case FILE: return null;
			case EDIT: return null;
			case SETTINGS: return null;
			default: return null;
		}
	}
}
