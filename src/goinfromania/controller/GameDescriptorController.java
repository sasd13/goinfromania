package goinfromania.controller;

import goinfromania.controller.engine.GameEngine;
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
			GameEngine.actionContinue(this.game);
		} else if ("DELETE".equalsIgnoreCase(command)) {
			this.gameDescriptorPane.clear();
			
			GameEngine.actionDelete(this.game);
		}
	}
}
