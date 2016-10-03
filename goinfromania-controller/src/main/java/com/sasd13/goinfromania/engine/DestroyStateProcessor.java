package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;

public class DestroyStateProcessor implements IStateProcessor {

	@Override
	public void process(int stateTarget, Game game, IGameView gameView) {
		if (game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
			destroyGame(game);
		}
	}

	private void destroyGame(Game game) {
		game.setState(EnumState.DESTROYED);
		game.deleteObservers();
	}
}
