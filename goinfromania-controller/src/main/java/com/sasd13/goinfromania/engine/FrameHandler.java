package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class FrameHandler {

	public static void closeFrame(IFrame frame, Game game) {
		if (game != null && game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			GameHandler.pauseGame(game);
		}

		if (frame.askClose()) {
			if (game != null && game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
				GameHandler.finishGame(game);
			}

			if (game == null || game.getState() == EnumState.DESTROYED) {
				frame.dispose();
				System.exit(0);
			}
		}
	}
}
