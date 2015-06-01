package pattern.factory;

import java.util.prefs.Preferences;

import game.setting.Setting;

public interface SettingPreferences {
	
	public static final String CLASS_NAME = Setting.class.getName();
	
	public Preferences getPreferences();
	
	public void save(Setting setting);
	
	public Setting load();
}
