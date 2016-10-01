package com.sasd13.goinfromania.controller.menu.file;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IAction;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.engine.GameEngine;

public class MenuFileActionExit implements IAction {
	
	private Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void execute(IFrame frame) {		
		if (frame.askClose()) {
			if (game != null && game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
				GameEngine.finishGame(game, frame);
			}
			
			frame.dispose();
			System.exit(0);
		}
	}
}
