package com.sasd13.goinfromania.util.preferences;

import com.sasd13.goinfromania.bean.setting.EnumSettingType;

public class SettingPreferencesFactory {

	public static SettingPreferences make(EnumSettingType settingType) {
		switch (settingType) {
			case GAMEPAD: return new GamePadPreferences();
			default: return null;
		}
	}
}
