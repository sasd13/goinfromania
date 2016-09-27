package com.sasd13.goinfromania.util.preferences;

import com.sasd13.goinfromania.bean.setting.EnumSettingType;

public class SettingPreferencesFactory {

	public static SettingPreferences make(String code) {
		if (EnumSettingType.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new GamePadPreferences();
		} else {
			return null;
		}
	}
}
