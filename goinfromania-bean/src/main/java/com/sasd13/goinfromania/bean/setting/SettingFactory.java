package com.sasd13.goinfromania.bean.setting;

public class SettingFactory {

	private SettingFactory() {}
	
	public static Setting make(String code) {
		if (EnumSettingType.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new GamePad();
		} else {
			return null;
		}
	}
}