package com.sasd13.goinfromania.controller.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IFrame;

public class SettingDialogController implements ActionListener {

	private IFrame frame;
	private ISettingDialog settingDialog;
	private Setting setting;

	public SettingDialogController(IFrame frame, ISettingDialog settingDialog, Setting setting) {
		this.frame = frame;
		this.settingDialog = settingDialog;
		this.setting = setting;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SettingDialogActionFactory.make(e.getActionCommand(), settingDialog, setting).execute(frame);
	}
}
