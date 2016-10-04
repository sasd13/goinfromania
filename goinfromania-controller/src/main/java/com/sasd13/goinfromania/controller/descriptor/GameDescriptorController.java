package com.sasd13.goinfromania.controller.descriptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrameView;

public class GameDescriptorController implements ActionListener {

	private IFrameView frameView;
	private IDescriptorView descriptorView;
	private Game game;

	public GameDescriptorController(IFrameView frameView, IDescriptorView descriptorView) {
		this.frameView = frameView;
		this.descriptorView = descriptorView;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		GameDescriptorActionFactory.make(event.getActionCommand(), descriptorView, game).execute(frameView);
	}
}
