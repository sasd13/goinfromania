package main.java.pattern.dao;

import main.java.game.setting.Setting;
import main.java.pattern.factory.SettingPreferences;
import main.java.pattern.factory.SettingPreferencesFactory;

public class SettingDAO {

	public static Setting load(String settingName) {
		Setting setting = null;
		
		try {
			SettingPreferences settingPreferences = SettingPreferencesFactory.getPreferences(settingName);
			setting = settingPreferences.get();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return setting;
	}
	
	public static void save(Setting setting) {
		try {
			SettingPreferences settingPreferences = SettingPreferencesFactory.getPreferences(setting.getName());
			settingPreferences.put(setting);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
