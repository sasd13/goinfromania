package com.sasd13.goinfromania.controller.result;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameHandler;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IDialogView;
import com.sasd13.goinfromania.controller.IFrameView;

public class GameResultActionFinish implements IAction {

	private IDialogView dialogView;
	private Game game;

	public GameResultActionFinish(IDialogView dialogView, Game game) {
		this.dialogView = dialogView;
		this.game = game;
	}

	@Override
	public void execute(IFrameView frameView) {
		GameHandler.finishGame(game);
		dialogView.dispose();
		frameView.displayHome();
	}
}
