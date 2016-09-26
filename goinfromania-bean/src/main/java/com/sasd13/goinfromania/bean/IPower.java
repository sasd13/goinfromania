package com.sasd13.goinfromania.bean;

public interface IPower extends IMovable {
	
	boolean isAfar();
	
	void setAfar(boolean afar);

	int getPowerValue();
	
	void setPowerValue(int powerValue);
}
