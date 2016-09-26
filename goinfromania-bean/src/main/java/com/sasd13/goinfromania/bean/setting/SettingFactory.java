package com.sasd13.goinfromania.bean.setting;

public class SettingFactory {

	private SettingFactory() {}
	
	public static Setting make(EnumSettingType type) {
		switch (type) {
			case GAMEPAD: return new GamePad();
			default: return null;
		}
	}
}
