package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.dao.GameDAO;

public class StopStateProcessor implements IStateProcessor {

	private DestroyStateProcessor next;

	@Override
	public void process(int stateTarget, Game game, IGameView gameView) {
		if (game.getState().getOrder() < EnumState.STOPPED.getOrder()) {
			if (gameView.askSave()) {
				GameDAO.update(game);
			}

			stopGame(game);
		}

		if (stateTarget > EnumState.STOPPED.getOrder()) {
			if (next == null) {
				next = new DestroyStateProcessor();
			}

			next.process(stateTarget, game, gameView);
		}
	}

	private void stopGame(Game game) {
		game.setState(EnumState.STOPPED);
	}
}
