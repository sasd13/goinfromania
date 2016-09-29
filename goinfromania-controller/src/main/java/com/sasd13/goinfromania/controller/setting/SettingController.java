package com.sasd13.goinfromania.controller.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IFrame;

public class SettingController implements ActionListener {

	private IFrame frame;
	private ISettingDialog settingDialog;
	private Setting setting;

	public SettingController(IFrame frame, ISettingDialog settingDialog, Setting setting) {
		this.frame = frame;
		this.settingDialog = settingDialog;
		this.setting = setting;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SettingActionFactory.make(e.getActionCommand(), settingDialog, setting).execute(frame);
	}
}
