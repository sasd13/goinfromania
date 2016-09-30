package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrame;

public class GameEngine {

	public static void requestState(EnumState state, Game game, IFrame frame) {
		new CreateStateProcessor(frame).process(state.getOrder(), game);
	}
}
