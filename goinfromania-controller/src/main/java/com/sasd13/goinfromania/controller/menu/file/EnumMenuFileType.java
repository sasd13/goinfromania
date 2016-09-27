package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.controller.menu.IMenuItemType;

public enum EnumMenuFileType implements IMenuItemType {
	NEW("NEW"),
	OPEN("OPEN"),
	EXIT("EXIT"),
	;
	
	private String code;
	
	private EnumMenuFileType(String code) {
		this.code = code;
	}

	@Override
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
