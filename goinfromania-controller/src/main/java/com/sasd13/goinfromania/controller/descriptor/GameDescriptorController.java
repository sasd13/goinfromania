package com.sasd13.goinfromania.controller.descriptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.GameEngine;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorController implements ActionListener {
	
	private IFrame frame;
	private Game game;
	
	public GameDescriptorController(IFrame frame) {
		this.frame = frame;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		GameDescriptorActionFactory.make(event.getActionCommand()).execute(frame);
	}
}
