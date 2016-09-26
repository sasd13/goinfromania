package com.sasd13.goinfromania.util.preferences;

import java.util.prefs.Preferences;

import com.sasd13.goinfromania.bean.setting.Setting;

public abstract class SettingPreferences {
	
	protected abstract Preferences getPreferences();
	
	public abstract Setting pull();
	
	public abstract void push(Setting setting);
}
