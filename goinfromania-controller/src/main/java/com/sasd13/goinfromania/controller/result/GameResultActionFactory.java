package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialog;

public class GameResultActionFactory {

	private GameResultActionFactory() {}

	public static IAction make(String code, IDialog dialog, Game game) {
		if (EnumGameResultAction.REPLAY.getCode().equalsIgnoreCase(code)) {
			return new GameResultActionReplay(dialog, game);
		} else if (EnumGameResultAction.FINISH.getCode().equalsIgnoreCase(code)) {
			return new GameResultActionFinish(dialog, game);
		} else {
			return null;
		}
	}
}
