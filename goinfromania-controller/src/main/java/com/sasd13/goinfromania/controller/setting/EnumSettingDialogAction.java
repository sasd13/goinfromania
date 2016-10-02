package com.sasd13.goinfromania.controller.setting;

public enum EnumSettingDialogAction {
	CLOSE("CLOSE"), 
	SAVE("SAVE"), 
	RESET("RESET"),
	;

	private String code;

	private EnumSettingDialogAction(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumSettingDialogAction find(String code) {
		for (EnumSettingDialogAction action : values()) {
			if (action.code.equalsIgnoreCase(code)) {
				return action;
			}
		}

		return null;
	}
}
