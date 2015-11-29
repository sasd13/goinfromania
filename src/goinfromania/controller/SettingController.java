package goinfromania.controller;

import goinfromania.preferences.SettingPreferences;
import goinfromania.preferences.SettingPreferencesFactory;
import goinfromania.setting.Setting;
import goinfromania.view.dialog.SettingDialog;
import goinfromania.view.dialog.SettingDialogFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SettingController implements ActionListener {
	
	private Setting setting;
	private SettingDialog settingDialog;
	
	public SettingController(SettingDialog settingDialog) {
		this.settingDialog = settingDialog;
	}
	
	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if ("CLOSE".equalsIgnoreCase(command)) {
			actionClose();
		} else if ("SAVE".equalsIgnoreCase(command)) {
			actionSave();
		} else if ("RESET".equalsIgnoreCase(command)) {
			actionReset();
		}
	}

	private void actionClose() {
		this.settingDialog.dispose();
	}
	
	private void actionSave() {
		if (this.settingDialog.isFormValid()) {
			this.settingDialog.editSettingWithForm(this.setting);
			
			SettingPreferences settingPreferences = SettingPreferencesFactory.get(this.setting.getClass().getSimpleName());
			settingPreferences.push(this.setting);
		} else {
			JOptionPane.showMessageDialog(this.settingDialog, "Configuration erronée. Vous devez corriger", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void actionReset() {
		this.setting.reset();
	}
}
