package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;

public class DestroyStateProcessor implements IStateProcessor {

	private IGameView gameView;

	public DestroyStateProcessor(IGameView gameView) {
		this.gameView = gameView;
	}

	@Override
	public void process(int stateTarget, Game game) {
		if (game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
			game.setState(EnumState.DESTROYED);
			game.deleteObservers();
		}
	}
}
