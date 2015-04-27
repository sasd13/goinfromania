package game.setting;

import java.util.ArrayList;

public class ListSetting {
	
	private ArrayList<Setting> list;
	
	public ListSetting() {
		this.list = new ArrayList<>();
	}
	
	public boolean add(Setting setting) {
		setting = get(setting.getName());
		
		return this.list.add(setting);
	}
	
	public boolean remove(Setting setting) {
		setting = get(setting.getName());
		
		return this.list.remove(setting);
	}
	
	public Setting get(String settingName) {
		for (Setting setting : this.list) {
			if (setting.getId().compareTo(settingName) == 0) {
				return setting;
			}
		}
		
		return null;
	}
	
	public Setting get(int index) {
		return this.list.get(index);
	}
	
	public int size() {
		return this.list.size();
	}
}
