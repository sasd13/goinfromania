package com.sasd13.goinfromania.view.dialog;

public class SettingDialogFactory {

	public static SettingDialog make(String dialogName) {
		if ("GAMEPAD".equalsIgnoreCase(dialogName)) {
			return new SettingDialogGamePad();
		}
		
		return null;
	}
}
