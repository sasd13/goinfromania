package com.sasd13.goinfromania.view.dialog;

import com.sasd13.goinfromania.bean.setting.EnumSettingType;

public class SettingDialogFactory {

	public static SettingDialog make(String code) {
		if (EnumSettingType.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new SettingDialogGamePad();
		} else {
			return null;
		}
	}
}
