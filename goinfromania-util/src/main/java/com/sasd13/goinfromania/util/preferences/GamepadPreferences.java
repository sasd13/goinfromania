package com.sasd13.goinfromania.util.preferences;

import java.util.prefs.Preferences;

import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.bean.setting.Setting;

public class GamepadPreferences implements ISettingPreferences {

	private static final String KEY_START = "start";
	private static final String KEY_MOVE_NORTH = "move_north";
	private static final String KEY_MOVE_SOUTH = "move_south";
	private static final String KEY_MOVE_WEST = "move_west";
	private static final String KEY_MOVE_EAST = "move_east";
	private static final String KEY_PIG_ATTAK = "pig_attak";

	private Preferences getPreferences() {
		return Preferences.userRoot().node(Gamepad.class.getName());
	}

	@Override
	public Setting pull() {
		Gamepad gamepad = new Gamepad();

		Preferences preferences = getPreferences();

		gamepad.setKeyStart(preferences.getInt(KEY_START, gamepad.getKeyStart()));
		gamepad.setKeyMoveNorth(preferences.getInt(KEY_MOVE_NORTH, gamepad.getKeyMoveNorth()));
		gamepad.setKeyMoveSouth(preferences.getInt(KEY_MOVE_SOUTH, gamepad.getKeyMoveSouth()));
		gamepad.setKeyMoveWest(preferences.getInt(KEY_MOVE_WEST, gamepad.getKeyMoveWest()));
		gamepad.setKeyMoveEast(preferences.getInt(KEY_MOVE_EAST, gamepad.getKeyMoveEast()));
		gamepad.setKeyPigAttak(preferences.getInt(KEY_PIG_ATTAK, gamepad.getKeyPigAttak()));

		return gamepad;
	}

	@Override
	public void push(Setting setting) {
		Gamepad gamepad = (Gamepad) setting;

		Preferences preferences = getPreferences();

		preferences.putInt(KEY_START, gamepad.getKeyStart());
		preferences.putInt(KEY_MOVE_NORTH, gamepad.getKeyMoveNorth());
		preferences.putInt(KEY_MOVE_SOUTH, gamepad.getKeyMoveSouth());
		preferences.putInt(KEY_MOVE_WEST, gamepad.getKeyMoveWest());
		preferences.putInt(KEY_MOVE_EAST, gamepad.getKeyMoveEast());
		preferences.putInt(KEY_PIG_ATTAK, gamepad.getKeyPigAttak());
	}
}
