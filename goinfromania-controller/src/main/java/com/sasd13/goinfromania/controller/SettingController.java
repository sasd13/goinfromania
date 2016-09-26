package com.sasd13.goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.bean.setting.EnumSettingType;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class SettingController implements ActionListener {
	
	public static final String COMMAND_CLOSE = "CLOSE";
	public static final String COMMAND_SAVE = "SAVE";
	public static final String COMMAND_RESET = "RESET";
	
	private Setting setting;
	private EnumSettingType settingType;
	
	public void setSetting(Setting setting, EnumSettingType settingType) {
		this.setting = setting;
		this.settingType = settingType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (COMMAND_CLOSE.equalsIgnoreCase(command)) {
			actionClose();
		} else if (COMMAND_SAVE.equalsIgnoreCase(command)) {
			actionSave();
		} else if (COMMAND_RESET.equalsIgnoreCase(command)) {
			actionReset();
		}
	}

	private void actionClose() {
		//this.settingDialog.dispose();
	}
	
	private void actionSave() {
		/*if (this.settingDialog.isFormValid()) {
			this.settingDialog.editSettingWithForm(this.setting);
			
			performSave();
			
			JOptionPane.showMessageDialog(this.settingDialog, "Enregitsr�", "Option", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this.settingDialog, "Configuration erron�e. Veuillez corriger", "Erreur", JOptionPane.ERROR_MESSAGE);
		}*/
	}

	private void performSave() {
		SettingPreferencesFactory.make(settingType).push(this.setting);
	}
	
	private void actionReset() {
		/*int selected = JOptionPane.showConfirmDialog(this.settingDialog, "Vous ne pourrez pas annuler les modifications. Confirmer?", "Option", JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			this.setting.reset();
			
			performSave();
		}*/
	}
}
