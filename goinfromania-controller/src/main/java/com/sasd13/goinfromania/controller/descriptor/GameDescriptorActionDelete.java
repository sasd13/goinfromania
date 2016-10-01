package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorActionDelete implements IAction {

	private IDescriptor descriptor;

	public GameDescriptorActionDelete(IDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public void execute(IFrame frame) {
		if (descriptor.askDelete()) {
			descriptor.clear();
			GameDAO.delete(descriptor.getDescriptable());
			frame.displayGames(GameDAO.loadAll());
		}
	}
}
