package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IAction;

public class SettingDialogActionFactory {

	private SettingDialogActionFactory() {
	}

	public static IAction make(String code, ISettingDialog settingDialog, Setting setting) {
		if (EnumSettingDialogAction.CLOSE.getCode().equalsIgnoreCase(code)) {
			return new SettingDialogActionClose(settingDialog);
		} else if (EnumSettingDialogAction.SAVE.getCode().equalsIgnoreCase(code)) {
			return new SettingDialogActionSave(settingDialog, setting);
		} else if (EnumSettingDialogAction.RESET.getCode().equalsIgnoreCase(code)) {
			return new SettingDialogActionReset(settingDialog, setting);
		} else {
			return null;
		}
	}
}
