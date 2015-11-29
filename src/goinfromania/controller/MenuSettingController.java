package goinfromania.controller;

import java.awt.event.ActionEvent;

import goinfromania.preferences.SettingPreferences;
import goinfromania.preferences.SettingPreferencesFactory;
import goinfromania.setting.Setting;
import goinfromania.view.dialog.SettingDialog;
import goinfromania.view.dialog.SettingDialogFactory;

public class MenuSettingController extends MenuController {

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		SettingPreferences settingPreferences = SettingPreferencesFactory.get(command);
		Setting setting = settingPreferences.pull();
		
		SettingDialog settingDialog = SettingDialogFactory.get(command);
		setting.addObserver(settingDialog);
		
		settingDialog.update(setting, null);
		settingDialog.pack();
		settingDialog.setLocationRelativeTo(null);
		settingDialog.setVisible(true);
	}
}
