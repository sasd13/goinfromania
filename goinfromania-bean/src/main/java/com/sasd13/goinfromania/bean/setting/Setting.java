package com.sasd13.goinfromania.bean.setting;

import java.util.Observable;

public abstract class Setting extends Observable {
	
	protected Setting() {
		reset();
	}
	
	public abstract String getCode();
	
	public abstract void reset();
}
