package pattern.dao;

import game.setting.GamePad;
import game.setting.Setting;

public class SettingDAO {

	public static Setting load(String settingName) {
		Setting setting = null;
		
		//TODO Database query
		
		switch (settingName) {
			case GamePad.NAME :
				setting = new GamePad();
				break;
			default :
				//TODO Throw exception
				break;
		}
		
		//End Database query
		
		return setting;
	}
	
	public static void save(Setting setting) {
		//TODO Database query
	}
}
