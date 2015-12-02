package com.sasd13.goinfromania.bean.item;

public interface IEatable {

	boolean isNasty();
	
	void setNasty(boolean nasty);
	
	int getEatValue();
	
	void setEatValue(int eatValue);
}
