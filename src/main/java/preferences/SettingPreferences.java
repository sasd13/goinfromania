package main.java.preferences;

import java.util.prefs.Preferences;

import main.java.bean.setting.Setting;

public abstract class SettingPreferences {
	
	protected abstract Preferences getPreferences();
	
	public abstract Setting pull();
	
	public abstract void push(Setting setting);
}
