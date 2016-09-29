package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.preferences.SettingPreferences;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class MenuSettingsActionGamePad implements IAction {

	@Override
	public void execute(IFrame frame) {
		SettingPreferences settingPreferences = SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode());
		frame.displaySetting(settingPreferences.pull());
	}
}
