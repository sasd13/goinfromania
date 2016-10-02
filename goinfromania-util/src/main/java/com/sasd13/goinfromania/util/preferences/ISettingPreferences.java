package com.sasd13.goinfromania.util.preferences;

import com.sasd13.goinfromania.bean.setting.Setting;

public interface ISettingPreferences {

	Setting pull();

	void push(Setting setting);
}
