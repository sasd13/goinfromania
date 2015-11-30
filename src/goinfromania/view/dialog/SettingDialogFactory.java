package goinfromania.view.dialog;

import goinfromania.view.frame.Frame;

public class SettingDialogFactory {

	private SettingDialogFactory() {}
	
	public static SettingDialog get(String dialogName) {
		if ("GAMEPAD".equalsIgnoreCase(dialogName)) {
			return new SettingDialogGamePad();
		}
		
		return null;
	}
}
