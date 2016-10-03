package com.sasd13.goinfromania.view.dialog;

import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IFrameView;

public class SettingDialogFactory {

	private SettingDialogFactory() {
	}

	public static SettingDialog make(String code, Setting setting, IFrameView frameView) {
		if (EnumSetting.GAMEPAD.getCode().equalsIgnoreCase(code)) {
			return new SettingDialogGamepad(frameView, setting);
		} else {
			return null;
		}
	}
}
