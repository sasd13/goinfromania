package goinfromania.preference;

import goinfromania.setting.Setting;

import java.util.prefs.Preferences;

public abstract class SettingPreferences {
	
	protected abstract Preferences getPreferences();
	
	public abstract Setting pull();
	
	public abstract void push(Setting setting);
}
