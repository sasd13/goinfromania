package main.java.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.bean.setting.Setting;
import main.java.engine.GameEngine;
import main.java.preferences.SettingPreferencesFactory;
import main.java.view.dialog.SettingDialog;
import main.java.view.dialog.SettingDialogFactory;

public class MenuSettingController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		SettingDialog settingDialog = createDialogAndBindSetting(command);
		
		settingDialog.pack();
		settingDialog.setLocationRelativeTo(null);
		settingDialog.setVisible(true);
	}
	
	private SettingDialog createDialogAndBindSetting(String command) {
		SettingDialog settingDialog = SettingDialogFactory.get(command);
		
		bindSetting(command, settingDialog);
		
		return settingDialog;
	}

	private void bindSetting(String command, SettingDialog settingDialog) {
		Setting setting = readSetting(command);
		
		setting.addObserver(settingDialog);
		settingDialog.update(setting, null);
	}

	private Setting readSetting(String command) {
		Setting setting;
		
		if ("GAMEPAD".equalsIgnoreCase(command) && GameEngine.hasGameInProgress()) {
			setting = GameEngine.getGamePad();
		} else {
			setting = SettingPreferencesFactory.get(command).pull();
		}
		
		return setting;
	}
}
