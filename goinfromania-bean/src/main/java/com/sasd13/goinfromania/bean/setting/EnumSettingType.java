package com.sasd13.goinfromania.bean.setting;

public enum EnumSettingType {
	GAMEPAD("GAMEPAD"),
	;
	
	private String code;
	
	private EnumSettingType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static EnumSettingType find(String code) {
		for (EnumSettingType type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		
		return null;
	}
}
