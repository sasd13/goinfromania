package com.sasd13.goinfromania.controller.descriptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.IFrameView;

public class GameDescriptorController implements ActionListener {

	private IFrameView frameView;
	private IDescriptor descriptor;
	private Game game;

	public GameDescriptorController(IFrameView frameView, IDescriptor descriptor) {
		this.frameView = frameView;
		this.descriptor = descriptor;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		GameDescriptorActionFactory.make(event.getActionCommand(), descriptor, game).execute(frameView);
	}
}
