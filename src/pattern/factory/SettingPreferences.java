package pattern.factory;

import java.util.prefs.Preferences;

import game.setting.Setting;

public interface SettingPreferences {
	
	public static final String CLASS_NAME = Setting.class.getName();
	
	public Preferences getPreferences();
	
	public Setting get();
	
	public void put(Setting setting);
}
