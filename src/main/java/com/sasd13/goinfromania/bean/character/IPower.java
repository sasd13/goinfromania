package com.sasd13.goinfromania.bean.character;

import com.sasd13.goinfromania.bean.IMovable;

public interface IPower extends IMovable {
	
	boolean isAfar();
	
	void setAfar(boolean afar);

	int getPowerValue();
	
	void setPowerValue(int powerValue);
}
