package com.sasd13.goinfromania.controller;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class FrameHandler {

	public static void closeFrame(IFrameView frameView, Game game) {
		if (frameView.askClose()) {
			if (game != null && game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
				GameHandler.finishGame(game);
			}

			if (game == null || game.getState() == EnumState.DESTROYED) {
				frameView.dispose();
				System.exit(0);
			}
		}
	}
}
