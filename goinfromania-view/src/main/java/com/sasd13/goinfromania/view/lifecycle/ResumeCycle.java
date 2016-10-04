package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.view.GameView;

public class ResumeCycle implements ICycle {

	@Override
	public void execute(GameView gameView, Game game) {
		gameView.setGame(game);
		gameView.getArenaView().requestFocusInWindow();
		// TODO : resume game
	}
}
