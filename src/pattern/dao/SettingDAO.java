package pattern.dao;

import pattern.factory.SettingPreferences;
import pattern.factory.SettingPreferencesFactory;
import game.setting.Setting;

public class SettingDAO {

	public static Setting load(String settingName) {
		Setting setting = null;
		
		try {
			SettingPreferences settingPreferences = SettingPreferencesFactory.getPreferences(settingName);
			setting = settingPreferences.load();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return setting;
	}
	
	public static void save(Setting setting) {
		try {
			SettingPreferences settingPreferences = SettingPreferencesFactory.getPreferences(setting.getName());
			settingPreferences.save(setting);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
