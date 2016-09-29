package com.sasd13.goinfromania.view.dialog;

import com.sasd13.goinfromania.bean.setting.EnumSetting;

public class SettingDialogFactory {

	public static SettingDialog make(String code) {
		if (EnumSetting.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new SettingDialogGamePad();
		} else {
			return null;
		}
	}
}
