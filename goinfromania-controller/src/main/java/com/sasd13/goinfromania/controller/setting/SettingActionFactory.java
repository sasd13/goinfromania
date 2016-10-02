package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IAction;

public class SettingActionFactory {

	private SettingActionFactory() {}

	public static IAction make(String code, ISettingDialog settingDialog, Setting setting) {
		if (EnumSettingAction.CLOSE.getCode().equalsIgnoreCase(code)) {
			return new SettingActionClose(settingDialog);
		} else if (EnumSettingAction.SAVE.getCode().equalsIgnoreCase(code)) {
			return new SettingActionSave(settingDialog, setting);
		} else if (EnumSettingAction.RESET.getCode().equalsIgnoreCase(code)) {
			return new SettingActionReset(settingDialog, setting);
		} else {
			return null;
		}
	}
}
