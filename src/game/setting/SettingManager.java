package game.setting;

public class SettingManager {

	public static Setting load(String settingName) {
		Setting setting = null;
		
		//Database query
		
		return setting;
	}
	
	public static ListSetting loadAll() {
		ListSetting listSetting = new ListSetting();
		
		String[] tabSettingId = new String[1]; //Database query
		
		Setting setting;
		for(String settingId : tabSettingId) {
			setting = load(settingId);
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
