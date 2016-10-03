package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.controller.IGameView;

public class CreateStateProcessor implements IStateProcessor {

	private StartStateProcessor next;

	@Override
	public void process(int stateTarget, Game game, IGameView gameView) {
		if (game.getState().getOrder() < EnumState.CREATED.getOrder()) {
			createGame(game);
		}

		if (stateTarget > EnumState.CREATED.getOrder()) {
			if (next == null) {
				next = new StartStateProcessor();
			}

			next.process(stateTarget, game, gameView);
		}
	}

	private void createGame(Game game) {
		game.setState(EnumState.CREATED);
		game.setPig(new Pig());

		// frame.displayGame(game);
	}
}
