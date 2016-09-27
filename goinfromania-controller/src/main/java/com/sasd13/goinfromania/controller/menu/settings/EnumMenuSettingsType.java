package com.sasd13.goinfromania.controller.menu.settings;

public enum EnumMenuSettingsType {
	GAMEPAD("GAMEPAD"),
	;

	private String code;

	private EnumMenuSettingsType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumMenuSettingsType find(String code) {
		for (EnumMenuSettingsType type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}

		return null;
	}
}
