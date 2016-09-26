package com.sasd13.goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.dao.GameDAO;

public class GameDescriptorController implements ActionListener {
	
	private GameEngine gameEngine = GameEngine.getInstance();
	
	private Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("CONTINUE".equalsIgnoreCase(command)) {
			actionContinue();
		} else if ("DELETE".equalsIgnoreCase(command)) {
			actionDelete();
		}
	}
	
	private void actionContinue() {
		gameEngine.openGame(this.game);
		//FrameController.displayGame(game);
	}
	
	private void actionDelete() {
		//this.gameDescriptorPane.clear();
		
		GameDAO.delete(this.game);
		
		//FrameController.displayListGames();
	}
}
