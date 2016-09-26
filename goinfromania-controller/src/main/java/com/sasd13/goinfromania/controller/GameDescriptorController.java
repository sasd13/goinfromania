package com.sasd13.goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorController implements ActionListener {
	
	public static final String COMMAND_CONTINUE = "CONTINUE";
	public static final String COMMAND_DELETE = "DELETE";
	
	private GameEngine gameEngine = GameEngine.getInstance();
	private Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (COMMAND_CONTINUE.equalsIgnoreCase(command)) {
			actionContinue();
		} else if (COMMAND_DELETE.equalsIgnoreCase(command)) {
			actionDelete();
		}
	}
	
	private void actionContinue() {
		gameEngine.openGame(this.game);
	}
	
	private void actionDelete() {
		//this.gameDescriptorPane.clear();
		
		GameDAO.delete(this.game);
	}
}
