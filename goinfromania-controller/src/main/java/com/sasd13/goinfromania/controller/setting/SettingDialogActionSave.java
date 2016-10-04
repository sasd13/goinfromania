package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class SettingDialogActionSave implements IAction {

	private ISettingDialog settingDialog;
	private Setting setting;

	public SettingDialogActionSave(ISettingDialog settingDialog, Setting setting) {
		this.settingDialog = settingDialog;
		this.setting = setting;
	}

	@Override
	public void execute(IFrameView frameView) {
		if (settingDialog.save(setting)) {
			SettingPreferencesFactory.make(setting.getCode()).push(setting);
		}
	}
}
