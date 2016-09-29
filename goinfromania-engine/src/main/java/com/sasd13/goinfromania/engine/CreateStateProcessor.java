package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class CreateStateProcessor implements IStateProcessor {

	private StartStateProcessor next;

	public CreateStateProcessor() {
		next = new StartStateProcessor();
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (stateTarget == EnumState.CREATED.getOrder()) {
			game.setState(EnumState.CREATED);
			// TODO : process
		} else {
			next.process(stateTarget, game);
		}
	}
}
