package com.sasd13.goinfromania.view.dialog;

import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IFrame;

public class SettingDialogFactory {

	public static SettingDialog make(String code, Setting setting, IFrame frame) {
		if (EnumSetting.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new SettingDialogGamePad(frame, setting, code);
		} else {
			return null;
		}
	}
}
