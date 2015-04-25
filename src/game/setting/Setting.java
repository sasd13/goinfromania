package game.setting;

import java.util.Observable;

public abstract class Setting extends Observable {
	
	private String name;
	
	protected Setting() {
		super();
		
		this.name = null;
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
