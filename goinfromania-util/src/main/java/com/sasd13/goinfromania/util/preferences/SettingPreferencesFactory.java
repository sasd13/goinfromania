package com.sasd13.goinfromania.util.preferences;

import com.sasd13.goinfromania.bean.setting.EnumSetting;

public class SettingPreferencesFactory {

	private SettingPreferencesFactory() {}

	public static SettingPreferences make(String code) {
		if (EnumSetting.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new GamePadPreferences();
		} else {
			return null;
		}
	}
}
