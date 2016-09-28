package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.controller.ICommand;

public class GameResultCommandFactory {

	private GameResultCommandFactory() {}

	public static ICommand make(String code) {
		if (EnumGameResultType.REPLAY.getCode().equalsIgnoreCase(code)) {
			return new GameResultReplayCommand();
		} else if (EnumGameResultType.END.getCode().equalsIgnoreCase(code)) {
			return new GameResultEndCommand();
		} else {
			return null;
		}
	}
}
