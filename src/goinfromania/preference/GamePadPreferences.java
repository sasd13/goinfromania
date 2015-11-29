package goinfromania.preference;

import goinfromania.setting.GamePad;
import goinfromania.setting.Setting;

import java.util.prefs.Preferences;

public class GamePadPreferences extends SettingPreferences {
	
	private static final String CLASS_NAME = GamePad.class.getName();
	
	private static final String KEY_START = "start";
	private static final String KEY_MOVE_NORTH = "move_north";
	private static final String KEY_MOVE_SOUTH = "move_south";
	private static final String KEY_MOVE_WEST = "move_west";
	private static final String KEY_MOVE_EAST = "move_east";
	private static final String KEY_PIG_ATTAK = "pig_attak";
	
	@Override
	public Preferences getPreferences() {
		return Preferences.userRoot().node(CLASS_NAME);
	}
	
	@Override
	public Setting pull() {
		GamePad gamePad = new GamePad();
		
		Preferences prefs = getPreferences();
		
		gamePad.setKeyStart(prefs.getInt(KEY_START, gamePad.getKeyStart()));
		gamePad.setKeyMoveNorth(prefs.getInt(KEY_MOVE_NORTH, gamePad.getKeyMoveNorth()));
		gamePad.setKeyMoveSouth(prefs.getInt(KEY_MOVE_SOUTH, gamePad.getKeyMoveSouth()));
		gamePad.setKeyMoveWest(prefs.getInt(KEY_MOVE_WEST, gamePad.getKeyMoveWest()));
		gamePad.setKeyMoveEast(prefs.getInt(KEY_MOVE_EAST, gamePad.getKeyMoveEast()));
		gamePad.setKeyPigAttak(prefs.getInt(KEY_PIG_ATTAK, gamePad.getKeyPigAttak()));
		
		return gamePad;
	}

	@Override
	public void push(Setting setting) {
		GamePad gamePad = (GamePad) setting;
		
		Preferences prefs = getPreferences();
		
		prefs.putInt(KEY_START, gamePad.getKeyStart());
		prefs.putInt(KEY_MOVE_NORTH, gamePad.getKeyMoveNorth());
		prefs.putInt(KEY_MOVE_SOUTH, gamePad.getKeyMoveSouth());
		prefs.putInt(KEY_MOVE_WEST, gamePad.getKeyMoveWest());
		prefs.putInt(KEY_MOVE_EAST, gamePad.getKeyMoveEast());
		prefs.putInt(KEY_PIG_ATTAK, gamePad.getKeyPigAttak());
	}
}
