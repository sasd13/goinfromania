package com.sasd13.goinfromania.controller.menu.file;

public enum EnumMenuFileType {
	NEW("NEW"), 
	OPEN("OPEN"), 
	EXIT("EXIT"),
	;

	private String code;

	private EnumMenuFileType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EnumMenuFileType find(String code) {
		for (EnumMenuFileType type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}

		return null;
	}
}
