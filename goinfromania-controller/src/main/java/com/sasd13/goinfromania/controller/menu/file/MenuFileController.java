package com.sasd13.goinfromania.controller.menu.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameHandler;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuFileController implements ActionListener {

	private IFrameView frameView;
	private MenuFileActionFactory factory;
	private Game game;

	public MenuFileController(IFrameView frameView) {
		this.frameView = frameView;
		factory = new MenuFileActionFactory();
	}

	public void setGame(Game game) {
		this.game = game;
		
		factory.setGame(game);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (game != null && game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			GameHandler.pauseGame(game);
		}
		
		factory.make(event.getActionCommand()).execute(frameView);
	}
}
