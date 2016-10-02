package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class MenuSettingsActionGamepad implements IAction {

	@Override
	public void execute(IFrame frame) {
		Setting setting = SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode()).pull();
		frame.displaySetting(setting);
	}
}
