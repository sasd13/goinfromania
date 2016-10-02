package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class ResumeStateProcessor implements IStateProcessor {

	private IFrame frame;
	private PauseStateProcessor next;

	public ResumeStateProcessor(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.RESUMED.getOrder() || game.getState() == EnumState.PAUSED) {
			resumeGame(game);
		}

		if (stateTarget > EnumState.RESUMED.getOrder()) {
			if (next == null) {
				next = new PauseStateProcessor(frame);
			}

			next.process(stateTarget, game);
		}
	}

	private void resumeGame(Game game) {
		game.setState(EnumState.RESUMED);
		// TODO : process
	}
}
