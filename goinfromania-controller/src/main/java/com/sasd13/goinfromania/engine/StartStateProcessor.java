package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class StartStateProcessor implements IStateProcessor {
	
	private ResumeStateProcessor next;
	
	public StartStateProcessor() {
		next = new ResumeStateProcessor();
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.STARTED.getOrder()) {
			game.setState(EnumState.STARTED);
			// TODO : process
		}

		if (stateTarget > EnumState.STARTED.getOrder()) {
			next.process(stateTarget, game);
		}
	}
}