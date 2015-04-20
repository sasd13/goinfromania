package game.setting;

import game.Model;

import java.util.HashMap;

public class MapSetting extends Model {
	
	private HashMap<SettingType, Setting> map;
	
	public MapSetting() {
		setTitle("Settings");
		
		this.map = new HashMap<>();
	}
	
	public Setting put(Setting params) {
		SettingType paramsType = null;
		
		if(params instanceof KeyboardSetting) {
			paramsType = SettingType.KEYBOARD;
		} else {
			//Throw Exception
		}
		
		params = this.map.put(paramsType, params);
		
		notifyObservers();
		
		return params;
	}
	
	public Setting remove(Setting params) {
		params = this.map.remove(params);
		
		notifyObservers();
		
		return params;
	}
	
	public Setting get(SettingType paramsType) {
		return this.map.get(paramsType);
	}
}
