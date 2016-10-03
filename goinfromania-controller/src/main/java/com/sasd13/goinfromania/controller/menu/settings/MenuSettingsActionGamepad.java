package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class MenuSettingsActionGamepad implements IAction {

	private Gamepad gamepad;

	public void setGamepad(Gamepad gamepad) {
		this.gamepad = gamepad;
	}

	@Override
	public void execute(IFrameView frameView) {
		Setting setting = gamepad != null ? gamepad : SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode()).pull();

		frameView.displaySetting(setting);
	}
}
