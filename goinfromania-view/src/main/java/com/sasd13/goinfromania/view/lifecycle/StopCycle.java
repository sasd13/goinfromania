package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.view.FrameView;
import com.sasd13.goinfromania.view.GameView;
import com.sasd13.goinfromania.view.arena.ArenaView;
import com.sasd13.goinfromania.view.dialog.GameResultDialog;

public class StopCycle implements ICycle {

	private FrameView frameView;
	private GameResultDialog gameResultDialog;

	public StopCycle(FrameView frameView) {
		this.frameView = frameView;
	}

	@Override
	public void execute(Game game, GameView gameView, ArenaView arenaView) {
		if (gameResultDialog == null) {
			gameResultDialog = new GameResultDialog(frameView, game);
		}

		game.addObserver(gameResultDialog);
		gameResultDialog.update(game, null);
		gameResultDialog.setLocationRelativeTo(gameView);
		//gameResultDialog.setVisible(true);
	}
}
