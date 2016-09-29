package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class StopStateProcessor implements IStateProcessor {

	private DestroyStateProcessor next;

	public StopStateProcessor() {
		next = new DestroyStateProcessor();
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (stateTarget == EnumState.STOPPED.getOrder()) {
			game.setState(EnumState.STOPPED);
			// TODO : process
		} else {
			next.process(stateTarget, game);
		}
	}
}
