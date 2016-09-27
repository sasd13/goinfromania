package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.controller.menu.IMenuItemType;

public enum EnumMenuEditType implements IMenuItemType {
	PAUSE("PAUSE"), 
	STOP("STOP"), 
	SAVE("SAVE"),
	;

	private String code;

	private EnumMenuEditType(String code) {
		this.code = code;
	}

	@Override
	public String getCode() {
		return code;
	}

	public static EnumMenuEditType find(String code) {
		for (EnumMenuEditType type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}

		return null;
	}
}
