package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class SettingActionSave implements IAction {

	private ISettingDialog settingDialog;
	private Setting setting;
	private String code;

	public SettingActionSave(ISettingDialog settingDialog, Setting setting, String code) {
		this.settingDialog = settingDialog;
		this.setting = setting;
		this.code = code;
	}

	@Override
	public void execute(IFrame frame) {
		if (settingDialog.save(setting)) {
			SettingPreferencesFactory.make(code).push(setting);
		}
	}
}
