package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuSettingsActionGamepad implements IAction {

	private Gamepad gamepad;

	public void setGamepad(Gamepad gamepad) {
		this.gamepad = gamepad;
	}

	@Override
	public void execute(IFrameView frameView) {
		frameView.displaySetting(gamepad);
	}
}
