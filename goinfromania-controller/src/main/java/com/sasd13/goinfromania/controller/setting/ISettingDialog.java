package com.sasd13.goinfromania.controller.setting;

import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.IDialogView;

public interface ISettingDialog extends IDialogView {

	boolean save(Setting setting);

	boolean askReset();
}
