package game.setting;

import java.util.HashMap;

public class MapSetting {
	
	private HashMap<SettingType, Setting> map;
	
	public MapSetting() {
		super();
		
		this.map = new HashMap<>();
	}
	
	public Setting put(Setting setting) {
		SettingType settingType = null;
		
		if(setting.getClass().getSimpleName().compareTo("GamePad") == 0) {
			settingType = SettingType.GAMEPAD;
		} else {
			//Throw Exception
		}
		
		return this.map.put(settingType, setting);
	}
	
	public Setting remove(Setting setting) {
		return this.map.remove(setting);
	}
	
	public Setting get(SettingType settingType) {
		return this.map.get(settingType);
	}
	
	public int size() {
		return this.map.size();
	}
}
