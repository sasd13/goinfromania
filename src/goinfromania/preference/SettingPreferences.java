package goinfromania.preference;

import goinfromania.setting.Setting;

import java.util.prefs.Preferences;

public interface SettingPreferences {
	
	public Preferences getPreferences();
	
	public Setting get();
	
	public void put(Setting setting);
}
