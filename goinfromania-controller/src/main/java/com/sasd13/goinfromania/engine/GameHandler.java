package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class GameHandler {

	private static void requestState(EnumState state, Game game, IGameView gameView) {
		new CreateStateProcessor().process(state.getOrder(), game, gameView);
	}

	public static void launchGame(Game game, IFrame frame) {
		Gamepad gamepad = (Gamepad) SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode()).pull();

		frame.displayGame(game, gamepad);
		requestState(EnumState.RESUMED, game, frame.getGameView());
	}

	public static void resumeGame(Game game, IFrame frame) {
		requestState(EnumState.RESUMED, game, frame.getGameView());
	}

	public static void pauseGame(Game game, IFrame frame) {
		requestState(EnumState.PAUSED, game, frame.getGameView());
	}

	public static void stopGame(Game game, IFrame frame) {
		requestState(EnumState.STOPPED, game, frame.getGameView());
	}

	public static void finishGame(Game game, IFrame frame) {
		requestState(EnumState.DESTROYED, game, frame.getGameView());
	}
}
