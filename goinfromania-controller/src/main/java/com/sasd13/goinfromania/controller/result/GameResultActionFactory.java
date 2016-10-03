package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialogView;

public class GameResultActionFactory {

	private GameResultActionFactory() {
	}

	public static IAction make(String code, IDialogView dialogView, Game game) {
		if (EnumGameResultAction.REPLAY.getCode().equalsIgnoreCase(code)) {
			return new GameResultActionReplay(dialogView, game);
		} else if (EnumGameResultAction.FINISH.getCode().equalsIgnoreCase(code)) {
			return new GameResultActionFinish(dialogView, game);
		} else {
			return null;
		}
	}
}
