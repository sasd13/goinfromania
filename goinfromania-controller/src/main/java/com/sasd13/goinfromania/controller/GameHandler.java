package com.sasd13.goinfromania.controller;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.IPig;
import com.sasd13.goinfromania.engine.CreateStateProcessor;
import com.sasd13.goinfromania.util.builder.PigBuilder;

public class GameHandler {

	private static CreateStateProcessor createStateProcessor;
	private static PigBuilder pigBuilder;
	private static IGameView gameView;

	private static void requestState(EnumState state, Game game) {
		if (createStateProcessor == null) {
			createStateProcessor = new CreateStateProcessor();
		}

		createStateProcessor.process(state.getOrder(), game, gameView);
	}

	public static void launchGame(Game game, IFrameView frameView) {
		if (pigBuilder == null) {
			pigBuilder = new PigBuilder();
		}
		
		IPig pig = pigBuilder.build();
		game.getArena().setPig(pig);
		
		gameView = frameView.displayGame(game);

		requestState(EnumState.RESUMED, game);
	}

	public static void resumeGame(Game game) {
		requestState(EnumState.RESUMED, game);
	}

	public static void pauseGame(Game game) {
		requestState(EnumState.PAUSED, game);
	}

	public static void stopGame(Game game) {
		requestState(EnumState.STOPPED, game);
	}

	public static void finishGame(Game game) {
		requestState(EnumState.DESTROYED, game);
	}

	public static void finishGameWithAsking(Game game) {
		if (gameView.askStop()) {
			requestState(EnumState.DESTROYED, game);
		}
	}
}
