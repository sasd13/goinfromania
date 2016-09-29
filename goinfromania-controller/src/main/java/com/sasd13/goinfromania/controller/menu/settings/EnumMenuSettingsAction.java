package com.sasd13.goinfromania.controller.menu.settings;

public enum EnumMenuSettingsAction {
	GAMEPAD("GAMEPAD"),
	;

	private String code;

	private EnumMenuSettingsAction(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumMenuSettingsAction find(String code) {
		for (EnumMenuSettingsAction action : values()) {
			if (action.code.equalsIgnoreCase(code)) {
				return action;
			}
		}

		return null;
	}
}
