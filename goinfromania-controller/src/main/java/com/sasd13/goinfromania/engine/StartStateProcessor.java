package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;

public class StartStateProcessor implements IStateProcessor {

	private ResumeStateProcessor next;

	@Override
	public void process(int stateTarget, Game game, IGameView gameView) {
		if (game.getState().getOrder() < EnumState.STARTED.getOrder()) {
			startGame(game);
		}

		if (stateTarget > EnumState.STARTED.getOrder()) {
			if (next == null) {
				next = new ResumeStateProcessor();
			}

			next.process(stateTarget, game, gameView);
		}
	}

	private void startGame(Game game) {
		game.setState(EnumState.STARTED);
	}
}
