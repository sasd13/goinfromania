package com.sasd13.goinfromania.util.preferences;

import java.util.prefs.Preferences;

import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.bean.setting.Setting;

public class GamepadPreferences extends SettingPreferences {
	
	private static final String CLASS_NAME = Gamepad.class.getName();
	
	private static final String KEY_START = "start";
	private static final String KEY_MOVE_NORTH = "move_north";
	private static final String KEY_MOVE_SOUTH = "move_south";
	private static final String KEY_MOVE_WEST = "move_west";
	private static final String KEY_MOVE_EAST = "move_east";
	private static final String KEY_PIG_ATTAK = "pig_attak";
	
	@Override
	protected Preferences getPreferences() {
		return Preferences.userRoot().node(CLASS_NAME);
	}
	
	@Override
	public Setting pull() {
		Gamepad gamepad = new Gamepad();
		
		Preferences prefs = getPreferences();
		
		gamepad.setKeyStart(prefs.getInt(KEY_START, gamepad.getKeyStart()));
		gamepad.setKeyMoveNorth(prefs.getInt(KEY_MOVE_NORTH, gamepad.getKeyMoveNorth()));
		gamepad.setKeyMoveSouth(prefs.getInt(KEY_MOVE_SOUTH, gamepad.getKeyMoveSouth()));
		gamepad.setKeyMoveWest(prefs.getInt(KEY_MOVE_WEST, gamepad.getKeyMoveWest()));
		gamepad.setKeyMoveEast(prefs.getInt(KEY_MOVE_EAST, gamepad.getKeyMoveEast()));
		gamepad.setKeyPigAttak(prefs.getInt(KEY_PIG_ATTAK, gamepad.getKeyPigAttak()));
		
		return gamepad;
	}

	@Override
	public void push(Setting setting) {
		Gamepad gamepad = (Gamepad) setting;
		
		Preferences prefs = getPreferences();
		
		prefs.putInt(KEY_START, gamepad.getKeyStart());
		prefs.putInt(KEY_MOVE_NORTH, gamepad.getKeyMoveNorth());
		prefs.putInt(KEY_MOVE_SOUTH, gamepad.getKeyMoveSouth());
		prefs.putInt(KEY_MOVE_WEST, gamepad.getKeyMoveWest());
		prefs.putInt(KEY_MOVE_EAST, gamepad.getKeyMoveEast());
		prefs.putInt(KEY_PIG_ATTAK, gamepad.getKeyPigAttak());
	}
}
