package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.controller.IAction;

public class GameDescriptorActionFactory {

	private GameDescriptorActionFactory() {}

	public static IAction make(String code, IDescriptor descriptor) {
		if (EnumGameDescriptorAction.CONTINUE.getCode().equalsIgnoreCase(code)) {
			return new GameDescriptorActionContinue(descriptor.getDescriptable());
		} else if (EnumGameDescriptorAction.DELETE.getCode().equalsIgnoreCase(code)) {
			return new GameDescriptorActionDelete(descriptor);
		} else {
			return null;
		}
	}
}
