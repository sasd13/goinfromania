package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.controller.menu.IMenuItemCommand;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommandFactory;

public class MenuEditCommandFactory implements IMenuItemCommandFactory {

	@Override
	public IMenuItemCommand make(String code) {
		if (EnumMenuEditType.PAUSE.getCode().equalsIgnoreCase(code)) {
			return new MenuEditPauseCommand();
		} else if (EnumMenuEditType.STOP.getCode().equalsIgnoreCase(code)) {
			return new MenuEditStopCommand();
		} else if (EnumMenuEditType.SAVE.getCode().equalsIgnoreCase(code)) {
			return new MenuEditSaveCommand();
		} else {
			return null;
		}
	}
}
