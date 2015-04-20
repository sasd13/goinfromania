package game.setting;

public class SettingManager {

	public static Setting load(SettingType settingType) {
		//Database query
		
		switch (settingType) {
			case KEYBOARD : 
				return new KeyboardSetting();
			default :
				return null;
		}
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
	
	public static void save(Setting params) {
		
	}
}
