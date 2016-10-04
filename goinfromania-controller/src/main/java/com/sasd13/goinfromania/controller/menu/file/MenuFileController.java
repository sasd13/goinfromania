package com.sasd13.goinfromania.controller.menu.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrameView;

public class MenuFileController implements ActionListener {

	private IFrameView frameView;
	private MenuFileActionFactory factory;

	public MenuFileController(IFrameView frameView) {
		this.frameView = frameView;
		factory = new MenuFileActionFactory();
	}

	public void setGame(Game game) {
		factory.setGame(game);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		factory.make(event.getActionCommand()).execute(frameView);
	}
}
