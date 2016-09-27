package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.controller.menu.IMenuItemType;

public enum EnumMenuSettingsType implements IMenuItemType {
	GAMEPAD("GAMEPAD"),
	;

	private String code;

	private EnumMenuSettingsType(String code) {
		this.code = code;
	}

	@Override
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
