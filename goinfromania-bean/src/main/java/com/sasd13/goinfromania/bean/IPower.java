package com.sasd13.goinfromania.bean;

public interface IPower extends IMovable {
	
	boolean isAfar();
	
	void setAfar(boolean afar);

	int getIntensity();
	
	void setIntensity(int intensity);
}
