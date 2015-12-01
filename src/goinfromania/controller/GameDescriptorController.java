package goinfromania.controller;

import goinfromania.db.GameDAO;
import goinfromania.engine.GameEngine;
import goinfromania.game.Game;
import goinfromania.view.frame.GameDescriptorPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDescriptorController implements ActionListener {
	
	private Game game;
	
	private GameDescriptorPane gameDescriptorPane;
	
	public GameDescriptorController(GameDescriptorPane gameDescriptorPane) {
		this.gameDescriptorPane = gameDescriptorPane;
	}
	
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
		GameEngine.openGame(this.game);
	}
	
	private void actionDelete() {
		this.gameDescriptorPane.clear();
		
		GameDAO.delete(this.game);
		
		GameEngine.listGames();
	}
}
