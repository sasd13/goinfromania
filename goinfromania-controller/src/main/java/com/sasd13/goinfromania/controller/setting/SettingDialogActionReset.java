package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class SettingDialogActionReset implements IAction {

	private ISettingDialog settingDialog;
	private Setting setting;

	public SettingDialogActionReset(ISettingDialog settingDialog, Setting setting) {
		this.settingDialog = settingDialog;
		this.setting = setting;
	}

	@Override
	public void execute(IFrame frame) {
		if (settingDialog.askReset()) {
			setting.reset();
			SettingPreferencesFactory.make(setting.getCode()).push(setting);
		}
	}
}
