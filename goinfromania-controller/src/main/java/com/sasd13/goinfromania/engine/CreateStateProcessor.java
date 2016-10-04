package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.Arena;
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
			createGame(game, gameView);
		}

		if (stateTarget > EnumState.CREATED.getOrder()) {
			if (next == null) {
				next = new StartStateProcessor();
			}

			next.process(stateTarget, game, gameView);
		}
	}

	private void createGame(Game game, IGameView gameView) {
		game.setState(EnumState.CREATED);
		
		Arena arena = game.getArena();
		
		gameView.displayArena(arena);
		arena.setPig(pigBuilder.build());
	}
}
