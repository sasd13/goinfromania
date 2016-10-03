package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;

public class PauseStateProcessor implements IStateProcessor {

	private ResumeStateProcessor nextResume;
	private StopStateProcessor nextStop;

	@Override
	public void process(int stateTarget, Game game, IGameView gameView) {
		if (game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			pauseGame(game);
		}

		if (stateTarget == EnumState.RESUMED.getOrder()) {
			if (nextResume == null) {
				nextResume = new ResumeStateProcessor();
			}

			nextResume.process(stateTarget, game, gameView);
		} else if (stateTarget > EnumState.PAUSED.getOrder()) {
			if (nextStop == null) {
				nextStop = new StopStateProcessor();
			}

			nextStop.process(stateTarget, game, gameView);
		}
	}

	private void pauseGame(Game game) {
		game.setState(EnumState.PAUSED);
		// TODO : process
	}
}
