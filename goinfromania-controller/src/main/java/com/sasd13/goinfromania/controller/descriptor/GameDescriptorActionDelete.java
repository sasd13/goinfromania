package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorActionDelete implements IAction {

	private IDescriptor descriptor;
	private Game game;

	public GameDescriptorActionDelete(IDescriptor descriptor, Game game) {
		this.descriptor = descriptor;
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		if (descriptor.askDelete()) {
			descriptor.clear();
			GameDAO.delete(game);
			frame.displayGames(GameDAO.loadAll());
		}
	}
}
