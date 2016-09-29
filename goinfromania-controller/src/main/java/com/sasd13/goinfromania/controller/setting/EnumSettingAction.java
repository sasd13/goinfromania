package com.sasd13.goinfromania.controller.setting;

public enum EnumSettingAction {
	CLOSE("CLOSE"), 
	SAVE("SAVE"), 
	RESET("RESET"),
	;

	private String code;

	private EnumSettingAction(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumSettingAction find(String code) {
		for (EnumSettingAction action : values()) {
			if (action.code.equalsIgnoreCase(code)) {
				return action;
			}
		}

		return null;
	}
}
