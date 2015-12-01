package goinfromania.controller.menu;

import goinfromania.engine.GameEngine;
import goinfromania.preferences.SettingPreferencesFactory;
import goinfromania.setting.Setting;
import goinfromania.view.dialog.SettingDialog;
import goinfromania.view.dialog.SettingDialogFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		if ("GAMEPAD".equalsIgnoreCase(command)) {
			if (GameEngine.hasGameInProgress()) {
				setting = GameEngine.getGamePad();
			} else {
				setting = SettingPreferencesFactory.get(command).pull();
			}
		} else {
			setting = SettingPreferencesFactory.get(command).pull();
		}
		
		return setting;
	}
}
