package com.sasd13.goinfromania.controller.descriptor;

public enum EnumGameDescriptorAction {
	CONTINUE("CONTINUE"),
	DELETE("DELETE"),
	;
	
	private String code;
	
	private EnumGameDescriptorAction(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static EnumGameDescriptorAction find(String code) {
		for (EnumGameDescriptorAction action : values()) {
			if (action.code.equalsIgnoreCase(code)) {
				return action;
			}
		}
		
		return null;
	}
}
