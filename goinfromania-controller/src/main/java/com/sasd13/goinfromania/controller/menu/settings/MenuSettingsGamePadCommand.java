package com.sasd13.goinfromania.controller.menu.settings;

import com.sasd13.goinfromania.bean.setting.EnumSettingType;
import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.menu.IMenuItemCommand;

public class MenuSettingsGamePadCommand implements IMenuItemCommand {

	private GameEngine gameEngine = GameEngine.getInstance();

	@Override
	public void execute() {
		gameEngine.openSetting(EnumSettingType.GAMEPAD);
	}
}
