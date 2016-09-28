package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.bean.Game;

public interface IDescriptor {

	Game getDescriptable();
	
	void clear();
}
