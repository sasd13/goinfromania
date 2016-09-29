package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialog;

public class GameResultActionFactory {

	private GameResultActionFactory() {}

	public static IAction make(String code, IDialog dialog) {
		if (EnumGameResultAction.REPLAY.getCode().equalsIgnoreCase(code)) {
			return new GameResultActionReplay(dialog);
		} else if (EnumGameResultAction.END.getCode().equalsIgnoreCase(code)) {
			return new GameResultActionEnd(dialog);
		} else {
			return null;
		}
	}
}
