package com.sasd13.goinfromania.engine;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.EnumSetting;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.preferences.SettingPreferencesFactory;

public class GameHandler {

	private static IGameView gameView;

	private static void requestState(EnumState state, Game game) {
		new CreateStateProcessor().process(state.getOrder(), game, gameView);
	}

	public static void launchGame(Game game, IFrame frame) {
		Gamepad gamepad = (Gamepad) SettingPreferencesFactory.make(EnumSetting.GAMEPAD.getCode()).pull();
		gameView = frame.displayGame(game, gamepad);

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
		game.deleteObservers();
	}
}
