package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IDialog;

public interface ISettingDialog extends IDialog {

	boolean save(Setting setting);

	boolean reset();
}
