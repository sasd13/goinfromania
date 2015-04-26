package game.setting;

import java.util.Observable;

public abstract class Setting extends Observable {
	
	private static int countSetting = 0;
	private String id;
	private String name;
	
	protected Setting() {
		super();
		
		countSetting++;
		this.id = "id-setting-" + countSetting;
		this.name = null;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		
		setChanged();
		notifyObservers();
	}
	
	public abstract void reset();
}
