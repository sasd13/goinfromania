package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.ICommandFactory;

public class MenuFileCommandFactory implements ICommandFactory {

	@Override
	public ICommand make(String code) {
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
