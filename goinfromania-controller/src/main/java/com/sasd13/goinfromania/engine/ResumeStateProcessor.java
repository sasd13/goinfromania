package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class ResumeStateProcessor implements IStateProcessor {

	private PauseStateProcessor next;

	public ResumeStateProcessor() {
		next = new PauseStateProcessor();
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.RESUMED.getOrder()) {
			game.setState(EnumState.RESUMED);
			// TODO : process
		}

		if (stateTarget > EnumState.RESUMED.getOrder()) {
			next.process(stateTarget, game);
		}
	}
}
