package com.sasd13.goinfromania.controller.menu.edit;

public enum EnumMenuEditAction {
	PAUSE("PAUSE"), 
	STOP("STOP"), 
	SAVE("SAVE"),
	;

	private String code;

	private EnumMenuEditAction(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumMenuEditAction find(String code) {
		for (EnumMenuEditAction action : values()) {
			if (action.code.equalsIgnoreCase(code)) {
				return action;
			}
		}

		return null;
	}
}
