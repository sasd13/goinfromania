package com.sasd13.goinfromania.controller.menu.file;

public enum EnumMenuFileAction {
	NEW("NEW"), 
	OPEN("OPEN"), 
	EXIT("EXIT"),
	;

	private String code;

	private EnumMenuFileAction(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumMenuFileAction find(String code) {
		for (EnumMenuFileAction action : values()) {
			if (action.code.equalsIgnoreCase(code)) {
				return action;
			}
		}

		return null;
	}
}
