package com.sasd13.goinfromania.bean;

public interface IPig extends IElement, IMovable, ILiveable, IPowerful {

	boolean isGreedy();
	
	void setGreedy(boolean greedy);
}
