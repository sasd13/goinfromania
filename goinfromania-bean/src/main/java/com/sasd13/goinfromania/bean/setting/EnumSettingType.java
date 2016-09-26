package com.sasd13.goinfromania.bean.setting;

public enum EnumSettingType {
	GAMEPAD("GAMEPAD"),
	;
	
	private String name;
	
	private EnumSettingType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static EnumSettingType find(String name) {
		for (EnumSettingType type : values()) {
			if (type.name.equalsIgnoreCase(name)) {
				return type;
			}
		}
		
		return null;
	}
}
