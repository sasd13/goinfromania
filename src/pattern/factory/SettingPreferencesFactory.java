package pattern.factory;

import game.setting.GamePad;

public class SettingPreferencesFactory {

	public static SettingPreferences getPreferences(String settingName) {
		switch (settingName) {
			case GamePad.NAME: 
				return new GamePadPreferences();
			default:
				return null;
		}
	}
}
