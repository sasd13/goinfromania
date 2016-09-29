package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;

public class SettingActionClose implements IAction {

	private ISettingDialog settingDialog;

	public SettingActionClose(ISettingDialog settingDialog) {
		this.settingDialog = settingDialog;
	}

	@Override
	public void execute(IFrame frame) {
		settingDialog.close();
	}
}
