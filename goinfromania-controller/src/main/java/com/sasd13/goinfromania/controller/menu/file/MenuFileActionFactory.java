package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.menu.IMenuActionFactory;

public class MenuFileActionFactory implements IMenuActionFactory {

	@Override
	public IAction make(String code) {
		if (EnumMenuFileAction.NEW.getCode().equalsIgnoreCase(code)) {
			return new MenuFileActionNew();
		} else if (EnumMenuFileAction.OPEN.getCode().equalsIgnoreCase(code)) {
			return new MenuFileActionOpen();
		} else if (EnumMenuFileAction.EXIT.getCode().equalsIgnoreCase(code)) {
			return new MenuFileActionExit();
		} else {
			return null;
		}
	}
}
