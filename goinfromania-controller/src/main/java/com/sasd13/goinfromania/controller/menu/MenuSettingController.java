package com.sasd13.goinfromania.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.engine.GameEngine;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class MenuSettingController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		/*SettingDialog settingDialog = createDialogAndBindSetting(command);
		
		settingDialog.pack();
		settingDialog.setLocationRelativeTo(null);
		settingDialog.setVisible(true);*/
	}
	
	/*private SettingDialog createDialogAndBindSetting(String command) {
		/*SettingDialog settingDialog = SettingDialogFactory.make(command);
		
		bindSetting(command, settingDialog);
		
		return settingDialog;
	}*/

	/*private void bindSetting(String command, SettingDialog settingDialog) {
		Setting setting = readSetting(command);
		
		setting.addObserver(settingDialog);
		settingDialog.update(setting, null);
	}*/

	private Setting readSetting(String command) {
		Setting setting;
		
		if ("GAMEPAD".equalsIgnoreCase(command) && GameEngine.hasGameInProgress()) {
			setting = GameEngine.getGamePad();
		} else {
			setting = SettingPreferencesFactory.make(command).pull();
		}
		
		return setting;
	}
}
