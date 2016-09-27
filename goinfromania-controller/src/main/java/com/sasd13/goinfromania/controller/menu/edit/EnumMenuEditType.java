package com.sasd13.goinfromania.controller.menu.edit;

public enum EnumMenuEditType {
	PAUSE("PAUSE"), 
	STOP("STOP"), 
	SAVE("SAVE"),
	;

	private String code;

	private EnumMenuEditType(String code) {
		this.code = code;
	}

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
