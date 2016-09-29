package com.sasd13.goinfromania.bean.setting;

public enum EnumSetting {
	GAMEPAD("GAMEPAD"),
	;
	
	private String code;
	
	private EnumSetting(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static EnumSetting find(String code) {
		for (EnumSetting setting : values()) {
			if (setting.code.equalsIgnoreCase(code)) {
				return setting;
			}
		}
		
		return null;
	}
}
