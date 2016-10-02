package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class PauseStateProcessor implements IStateProcessor {

	private IFrame frame;
	private ResumeStateProcessor nextResume;
	private StopStateProcessor nextStop;

	public PauseStateProcessor(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			pauseGame(game);
		}

		if (stateTarget == EnumState.RESUMED.getOrder()) {
			if (nextResume == null) {
				nextResume = new ResumeStateProcessor(frame);
			}

			nextResume.process(stateTarget, game);
		} else if (stateTarget > EnumState.PAUSED.getOrder()) {
			if (nextStop == null) {
				nextStop = new StopStateProcessor(frame);
			}

			nextStop.process(stateTarget, game);
		}
	}

	private void pauseGame(Game game) {
		game.setState(EnumState.PAUSED);
		// TODO : process
	}
}
