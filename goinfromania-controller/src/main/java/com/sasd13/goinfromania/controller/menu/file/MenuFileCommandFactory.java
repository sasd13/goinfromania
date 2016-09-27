package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.controller.menu.IMenuItemCommand;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommandFactory;

public class MenuFileCommandFactory implements IMenuItemCommandFactory {

	@Override
	public IMenuItemCommand make(String code) {
		if (EnumMenuFileType.NEW.getCode().equalsIgnoreCase(code)) {
			return new MenuFileNewCommand();
		} else if (EnumMenuFileType.OPEN.getCode().equalsIgnoreCase(code)) {
			return new MenuFileOpenCommand();
		} else if (EnumMenuFileType.EXIT.getCode().equalsIgnoreCase(code)) {
			return new MenuFileExitCommand();
		} else {
			return null;
		}
	}
}
