package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.ICommandFactory;

public class MenuEditCommandFactory implements ICommandFactory {

	@Override
	public ICommand make(String code) {
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
