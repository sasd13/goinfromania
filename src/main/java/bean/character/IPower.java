package main.java.bean.character;

import main.java.bean.IMovable;

public interface IPower extends IMovable {
	
	boolean isAfar();

	int getPowerValue();
	
	void setPowerValue(int powerValue);
}
