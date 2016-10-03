package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;

public class ResumeStateProcessor implements IStateProcessor {

	private PauseStateProcessor next;

	@Override
	public void process(int stateTarget, Game game, IGameView gameView) {
		if (game.getState().getOrder() < EnumState.RESUMED.getOrder() 
				|| (game.getState() == EnumState.PAUSED && stateTarget == EnumState.RESUMED.getOrder())) {
			resumeGame(game);
		}

		if (stateTarget > EnumState.RESUMED.getOrder()) {
			if (next == null) {
				next = new PauseStateProcessor();
			}

			next.process(stateTarget, game, gameView);
		}
	}

	private void resumeGame(Game game) {
		game.setState(EnumState.RESUMED);
		// TODO : process
	}
}
