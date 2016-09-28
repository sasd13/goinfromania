package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.bean.setting.EnumSettingType;
import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.IFrame;

public class GameResultReplayCommand implements ICommand {

	private GameEngine gameEngine = GameEngine.getInstance();
	private IFrame frame;
	
	public GameResultReplayCommand(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void execute(IFrame frame) {
		// this.gameDialogResult.dispose();

		gameEngine.newGame();
	}
}
