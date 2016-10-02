package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.controller.IDialog;

public interface ISettingDialog extends IDialog {
	
	boolean save();

	boolean askReset();
}
