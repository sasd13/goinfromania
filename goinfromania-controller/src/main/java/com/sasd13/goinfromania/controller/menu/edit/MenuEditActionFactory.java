package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.menu.IMenuActionFactory;

public class MenuEditActionFactory implements IMenuActionFactory {

	@Override
	public IAction make(String code) {
		if (EnumMenuEditAction.PAUSE.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionPause();
		} else if (EnumMenuEditAction.STOP.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionStop();
		} else if (EnumMenuEditAction.SAVE.getCode().equalsIgnoreCase(code)) {
			return new MenuEditActionSave();
		} else {
			return null;
		}
	}
}
