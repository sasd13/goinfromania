package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorActionDelete implements ICommand {

	private IDescriptor descriptor;

	public GameDescriptorActionDelete(IDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public void execute(IFrame frame) {
		descriptor.clear();
		GameDAO.delete(descriptor.getDescriptable());
	}
}
