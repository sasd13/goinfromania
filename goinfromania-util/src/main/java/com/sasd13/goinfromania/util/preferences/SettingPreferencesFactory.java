package com.sasd13.goinfromania.util.preferences;

import com.sasd13.goinfromania.bean.setting.EnumSetting;

public class SettingPreferencesFactory {

	private SettingPreferencesFactory() {}

	public static ISettingPreferences make(String code) {
		if (EnumSetting.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new GamepadPreferences();
		} else {
			return null;
		}
	}
}
