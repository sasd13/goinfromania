package com.sasd13.goinfromania.bean.character;

import com.sasd13.goinfromania.bean.IPower;

public interface IPowerful extends IEnergetic {

	boolean isPowerful();
	
	void setPowerful(boolean powerful);
	
	IPower getPower();
}
