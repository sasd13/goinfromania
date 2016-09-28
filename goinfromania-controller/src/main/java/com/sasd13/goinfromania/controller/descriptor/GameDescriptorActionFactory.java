package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.controller.ICommand;

public class GameDescriptorActionFactory {

	private GameDescriptorActionFactory() {}
	
	public static ICommand make(String code, IDescriptor descriptor) {
		if (EnumGameDescriptorActionType.CONTINUE.getCode().equalsIgnoreCase(code)) {
			return new GameDescriptorActionContinue(descriptor);
		} else if (EnumGameDescriptorActionType.DELETE.getCode().equalsIgnoreCase(code)) {
			return new GameDescriptorActionDelete(descriptor);
		} else {
			return null;
		}
	}
}
