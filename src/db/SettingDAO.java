package db;

import game.setting.GamePad;
import game.setting.ListSettings;
import game.setting.Setting;

public class SettingDAO {

	public static Setting load(String settingName) {
		Setting setting = null;
		
		//Database query
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
		
		String[] tabSettingName = new String[1]; //Database query
		
		Setting setting;
		for(String settingName : tabSettingName) {
			setting = load(settingName);
			if (setting != null) {
				listSettings.add(setting);
			}
		}
		
		return listSettings;
	}
	
	public static void save(Setting setting) {
		//Database query
	}
	
	public static void saveAll(ListSettings listSettings) {
		for (int i=0; i<listSettings.size(); i++) {
			save(listSettings.get(i));
		}
	}
}
