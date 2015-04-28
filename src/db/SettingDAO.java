package db;

import game.setting.GamePad;
import game.setting.ListSettings;
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
		
		return setting;
	}
	
	public static ListSettings loadAll() {
		ListSettings listSettings = new ListSettings();
		
		//TODO Database query
		
		return listSettings;
	}
	
	public static void save(Setting setting) {
		//TODO Database query
	}
	
	public static void saveAll(ListSettings listSettings) {
		for (int i=0; i<listSettings.size(); i++) {
			save(listSettings.get(i));
		}
	}
}
