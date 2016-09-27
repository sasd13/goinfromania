package com.sasd13.goinfromania.controller.menu.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.setting.EnumSettingType;
import com.sasd13.goinfromania.controller.GameEngine;

public class MenuSettingsController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		GameEngine.getInstance().openSetting(EnumSettingType.find(event.getActionCommand()));
	}
}
