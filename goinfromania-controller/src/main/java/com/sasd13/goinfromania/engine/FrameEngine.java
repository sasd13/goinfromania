package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class FrameEngine {

	public static void closeFrame(IFrame frame, Game game) {
		if (game != null && game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			GameEngine.pauseGame(game, frame);
		}

		if (frame.askClose()) {
			if (game != null && game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
				GameEngine.finishGame(game, frame);
			}

			if (game == null || game.getState() == EnumState.DESTROYED) {
				frame.dispose();
				System.exit(0);
			}
		}
	}
}
