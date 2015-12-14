package com.sasd13.goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.preferences.SettingPreferences;
import com.sasd13.goinfromania.preferences.SettingPreferencesFactory;
import com.sasd13.goinfromania.view.dialog.SettingDialog;

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
			
			performSave();
			
			JOptionPane.showMessageDialog(this.settingDialog, "Enregitsr�", "Option", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this.settingDialog, "Configuration erron�e. Veuillez corriger", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void performSave() {
		SettingPreferences settingPreferences = SettingPreferencesFactory.make(this.setting.getClass().getSimpleName());
		settingPreferences.push(this.setting);
	}
	
	private void actionReset() {
		int selected = JOptionPane.showConfirmDialog(this.settingDialog, "Vous ne pourrez pas annuler les modifications. Confirmer?", "Option", JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			this.setting.reset();
			
			performSave();
		}
	}
}
