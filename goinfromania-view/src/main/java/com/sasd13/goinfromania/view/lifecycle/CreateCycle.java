package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.view.GameView;

public class CreateCycle implements ICycle {

	@Override
	public void execute(GameView gameView, Game game) {
		game.addObserver(gameView.getArenaView());
		gameView.setGame(game);
	}
}
