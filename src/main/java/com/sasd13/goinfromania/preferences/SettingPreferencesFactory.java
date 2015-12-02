package com.sasd13.goinfromania.preferences;

public class SettingPreferencesFactory {

	public static SettingPreferences get(String name) {
		if ("GAMEPAD".equalsIgnoreCase(name)) {
			return new GamePadPreferences();
		}
		
		return null;
	}
}
