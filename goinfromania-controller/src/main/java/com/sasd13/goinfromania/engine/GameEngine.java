package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class GameEngine {

	private static void requestState(EnumState state, Game game, IFrame frame) {
		new CreateStateProcessor(frame).process(state.getOrder(), game);
	}

	public static void launchNewGame(IFrame frame) {
		requestState(EnumState.RESUMED, new Game(), frame);
	}

	public static void launchGame(Game game, IFrame frame) {
		requestState(EnumState.RESUMED, game, frame);
	}

	public static void resumeGame(Game game, IFrame frame) {
		requestState(EnumState.RESUMED, game, frame);
	}

	public static void pauseGame(Game game, IFrame frame) {
		requestState(EnumState.PAUSED, game, frame);
	}

	public static void stopGame(Game game, IFrame frame) {
		requestState(EnumState.STOPPED, game, frame);
	}

	public static void finishGame(Game game, IFrame frame) {
		requestState(EnumState.DESTROYED, game, frame);
	}
}
