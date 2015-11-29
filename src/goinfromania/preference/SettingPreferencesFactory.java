package goinfromania.preference;

public class SettingPreferencesFactory {

	public static SettingPreferences get(String className) {
		if ("GAMEPAD".equalsIgnoreCase(className)) {
			return new GamePadPreferences();
		}
		
		return null;
	}
}
