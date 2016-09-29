package com.sasd13.goinfromania.controller.menu.edit;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class MenuEditActionSave implements IAction {

	private Game game;

	public MenuEditActionSave(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {
		//TODO : do in background
		GameDAO.update(game);
	}
}
