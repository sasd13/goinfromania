package game.setting;

import game.Model;

import java.util.HashMap;

public class MapSetting extends Model {
	
	private HashMap<SettingType, Setting> map;
	
	public MapSetting() {
		setTitle("Settings");
		
		this.map = new HashMap<>();
	}
	
	public Setting put(Setting setting) {
		SettingType settingType = null;
		
		if(setting.getClass().getSimpleName().compareTo("GamePad") == 0) {
			settingType = SettingType.GAMEPAD;
		} else {
			//Throw Exception
		}
		
		setting = this.map.put(settingType, setting);
		
		notifyObservers();
		
		return setting;
	}
	
	public Setting remove(Setting setting) {
		setting = this.map.remove(setting);
		
		notifyObservers();
		
		return setting;
	}
	
	public Setting get(SettingType settingType) {
		return this.map.get(settingType);
	}
	
	public int size() {
		return this.map.size();
	}
}
