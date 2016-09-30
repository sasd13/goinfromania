package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class PauseStateProcessor implements IStateProcessor {

	private ResumeStateProcessor nextResume;
	private StopStateProcessor nextStop;

	public PauseStateProcessor() {
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
