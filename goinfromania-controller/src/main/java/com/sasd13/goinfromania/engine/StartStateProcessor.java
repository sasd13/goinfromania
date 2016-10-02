package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class StartStateProcessor implements IStateProcessor {

	private IFrame frame;
	private ResumeStateProcessor next;

	public StartStateProcessor(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.STARTED.getOrder()) {
			startGame(game);
		}

		if (stateTarget > EnumState.STARTED.getOrder()) {
			if (next == null) {
				next = new ResumeStateProcessor(frame);
			}

			next.process(stateTarget, game);
		}
	}

	private void startGame(Game game) {
		game.setState(EnumState.STARTED);
		// TODO : process
	}
}
