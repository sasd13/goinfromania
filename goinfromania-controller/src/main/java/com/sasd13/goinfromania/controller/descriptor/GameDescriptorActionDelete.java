package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.controller.ICommand;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorActionDelete implements ICommand {

	@Override
	public void execute(IFrame frame) {
		// this.gameDescriptorPane.clear();

		GameDAO.delete(this.game);
	}
}
