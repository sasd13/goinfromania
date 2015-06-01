package game.setting;

import java.io.Serializable;
import java.util.Observable;

public abstract class Setting extends Observable implements Serializable {
	
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
