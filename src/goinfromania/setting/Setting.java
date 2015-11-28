package goinfromania.setting;

import java.util.Observable;

public abstract class Setting extends Observable {
	
	protected Setting() {
		reset();
	}
	
	public abstract String getName();
	
	public abstract void reset();
}
