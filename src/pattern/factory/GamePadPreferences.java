package pattern.factory;

import game.setting.GamePad;
import game.setting.Setting;

import java.awt.event.KeyEvent;
import java.util.prefs.Preferences;

public class GamePadPreferences implements SettingPreferences {
	
	public static final String CLASS_NAME = GamePad.class.getName();
	
	public static final String KEY_START = "start";
	public static final String KEY_MOVE_NORTH = "move_north";
	public static final String KEY_MOVE_SOUTH = "move_south";
	public static final String KEY_MOVE_WEST = "move_west";
	public static final String KEY_MOVE_EAST = "move_east";
	public static final String KEY_PIG_ATTAK = "pig_attak";
	
	@Override
	public Preferences getPreferences() {
		return Preferences.userRoot().node(CLASS_NAME);
	}

	@Override
	public void save(Setting setting) {
		Preferences prefs = getPreferences();
		
		GamePad gamePad = (GamePad) setting;
		
		prefs.putInt(KEY_START, gamePad.getKeyStart());
		prefs.putInt(KEY_MOVE_NORTH, gamePad.getKeyMoveNorth());
		prefs.putInt(KEY_MOVE_SOUTH, gamePad.getKeyMoveSouth());
		prefs.putInt(KEY_MOVE_WEST, gamePad.getKeyMoveWest());
		prefs.putInt(KEY_MOVE_EAST, gamePad.getKeyMoveEast());
		prefs.putInt(KEY_PIG_ATTAK, gamePad.getKeyPigAttak());
	}

	@Override
	public Setting load() {
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
}
