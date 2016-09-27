package com.sasd13.goinfromania.controller.descriptor;

public enum EnumGameDescriptorActionType {
	CONTINUE("CONTINUE"),
	DELETE("DELETE"),
	;
	
	private String code;
	
	private EnumGameDescriptorActionType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static EnumGameDescriptorActionType find(String code) {
		for (EnumGameDescriptorActionType type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		
		return null;
	}
}
