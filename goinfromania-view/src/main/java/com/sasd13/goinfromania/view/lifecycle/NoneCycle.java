package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.view.GameView;
import com.sasd13.goinfromania.view.arena.ArenaView;

public class NoneCycle implements ICycle {

	@Override
	public void execute(Game game, GameView gameView, ArenaView arenaView) {
		gameView.clear();
	}
}
