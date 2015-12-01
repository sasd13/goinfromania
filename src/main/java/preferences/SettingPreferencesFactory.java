package main.java.preferences;

public class SettingPreferencesFactory {

	public static SettingPreferences get(String name) {
		if ("GAMEPAD".equalsIgnoreCase(name)) {
			return new GamePadPreferences();
		}
		
		return null;
	}
}
