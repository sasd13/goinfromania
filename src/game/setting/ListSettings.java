package game.setting;

import java.util.ArrayList;

public class ListSettings {
	
	private ArrayList<Setting> list;
	
	public ListSettings() {
		this.list = new ArrayList<>();
	}
	
	public boolean add(Setting setting) {
		return this.list.add(setting);
	}
	
	public boolean remove(Setting setting) {
		return this.list.remove(setting);
	}
	
	public Setting get(String settingName) {
		for (Setting setting : this.list) {
			if (setting.getName().compareTo(settingName) == 0) {
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
