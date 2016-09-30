package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;

public class PauseStateProcessor implements IStateProcessor {

	private IGameView gameView;
	private ResumeStateProcessor nextResume;
	private StopStateProcessor nextStop;

	public PauseStateProcessor(IGameView gameView) {
		this.gameView = gameView;
		nextResume = new ResumeStateProcessor();
		nextStop = new StopStateProcessor();
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			game.setState(EnumState.PAUSED);
			// TODO : process
		}

		if (stateTarget == EnumState.RESUMED.getOrder()) {
			nextResume.process(stateTarget, game);
		} else if (stateTarget > EnumState.PAUSED.getOrder()) {
			nextStop.process(stateTarget, game);
		}
	}
}
