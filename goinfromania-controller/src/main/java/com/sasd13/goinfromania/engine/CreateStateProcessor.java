package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.builder.PigBuilder;

public class CreateStateProcessor implements IStateProcessor {

	private StartStateProcessor next;
	private PigBuilder pigBuilder;

	public CreateStateProcessor() {
		pigBuilder = new PigBuilder();
	}

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
		game.setPig(pigBuilder.build());

		// frame.displayGame(game);
	}
}
