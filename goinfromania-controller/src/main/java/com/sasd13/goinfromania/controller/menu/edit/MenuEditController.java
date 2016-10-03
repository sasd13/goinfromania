package com.sasd13.goinfromania.controller.menu.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuEditController implements ActionListener {

	private IFrameView frameView;
	private Game game;

	public MenuEditController(IFrameView frameView) {
		this.frameView = frameView;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		MenuEditActionFactory.make(event.getActionCommand(), game).execute(frameView);
	}
}
