package com.sasd13.goinfromania.controller.setting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IFrameView;

public class SettingDialogController implements ActionListener {

	private IFrameView frameView;
	private ISettingDialog settingDialog;
	private Setting setting;

	public SettingDialogController(IFrameView frameView, ISettingDialog settingDialog, Setting setting) {
		this.frameView = frameView;
		this.settingDialog = settingDialog;
		this.setting = setting;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SettingDialogActionFactory.make(e.getActionCommand(), settingDialog, setting).execute(frameView);
	}
}
