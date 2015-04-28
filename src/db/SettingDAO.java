package db;

import game.setting.GamePad;
import game.setting.ListSetting;
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
	
	public static ListSetting loadAll() {
		ListSetting listSetting = new ListSetting();
		
		String[] tabSettingName = new String[1]; //Database query
		
		Setting setting;
		for(String settingName : tabSettingName) {
			setting = load(settingName);
			if (setting != null) {
				listSetting.add(setting);
			}
		}
		
		return listSetting;
	}
	
	public static void save(Setting setting) {
		//Database query
	}
	
	public static void saveAll(ListSetting listSetting) {
		for (int i=0; i<listSetting.size(); i++) {
			save(listSetting.get(i));
		}
	}
}
