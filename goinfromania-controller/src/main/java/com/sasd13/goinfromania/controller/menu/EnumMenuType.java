package com.sasd13.goinfromania.controller.menu;

public enum EnumMenuType {
	FILE("FILE"), 
	EDIT("EDIT"), 
	SETTINGS("SETTINGS"),
	;
	
	private String code;
	
	private EnumMenuType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static EnumMenuType find(String code) {
		for (EnumMenuType type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		
		return null;
	}
}
