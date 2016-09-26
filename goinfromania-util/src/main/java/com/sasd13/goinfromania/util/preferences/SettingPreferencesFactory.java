package com.sasd13.goinfromania.util.preferences;

public class SettingPreferencesFactory {

	public static SettingPreferences make(String name) {
		if ("GAMEPAD".equalsIgnoreCase(name)) {
			return new GamePadPreferences();
		}
		
		return null;
	}
}