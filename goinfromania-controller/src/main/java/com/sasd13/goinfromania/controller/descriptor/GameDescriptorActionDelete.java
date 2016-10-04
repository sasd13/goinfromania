package com.sasd13.goinfromania.controller.descriptor;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorActionDelete implements IAction {

	private IDescriptorView descriptorView;
	private Game game;

	public GameDescriptorActionDelete(IDescriptorView descriptorView, Game game) {
		this.descriptorView = descriptorView;
		this.game = game;
	}

	@Override
	public void execute(IFrameView frameView) {
		if (descriptorView.askDelete()) {
			descriptorView.clear();
			GameDAO.delete(game);
			frameView.displayGames(GameDAO.loadAll());
		}
	}
}
