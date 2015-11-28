package goinfromania.data.preference;

public class SettingPreferencesFactory {

	public static SettingPreferences get(String className) {
		if ("GAMEPAD".equalsIgnoreCase(className)) {
			return new GamePadPreferences();
		} else {
			return null;
		}
	}
}
