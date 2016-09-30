package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class CreateStateProcessor implements IStateProcessor {

	private IFrame frame;
	private StartStateProcessor next;

	public CreateStateProcessor(IFrame frame) {
		this.frame = frame;
		next = new StartStateProcessor();
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.CREATED.getOrder()) {
			game.setState(EnumState.CREATED);
			// TODO : process
			frame.displayGame(game);
		}

		if (stateTarget > EnumState.CREATED.getOrder()) {
			next.process(stateTarget, game);
		}
	}
}
