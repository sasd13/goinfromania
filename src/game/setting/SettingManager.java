package game.setting;

public class SettingManager {

	public static Setting load(SettingType settingType) {
		Setting setting = null;
		
		switch (settingType) {
			case GAMEPAD : 
				setting = new GamePad();
			default :
				//Throw exception
				break;
		}
		
		return setting;
	}
	
	public static MapSetting loadAll() {
		MapSetting mapSetting = new MapSetting();
		
		Setting setting;
		for(SettingType settingType : SettingType.values()) {
			setting = load(settingType);
			mapSetting.put(setting);
		}
		
		return mapSetting;
	}
	
	public static void save(Setting setting) {
		//Database query
	}
	
	public static void saveAll(MapSetting mapSetting) {
		for (SettingType settingType : SettingType.values()) {
			save(mapSetting.get(settingType));
		}
	}
}
