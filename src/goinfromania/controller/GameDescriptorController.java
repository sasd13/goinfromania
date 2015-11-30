package goinfromania.controller;

import goinfromania.game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDescriptorController implements ActionListener {
	
	private Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		GameEngine gameEngine = GameEngine.getInstance();
		
		if ("CONTINUE".equalsIgnoreCase(command)) {
			gameEngine.actionContinue(this.game);
		} else if ("DELETE".equalsIgnoreCase(command)) {
			gameEngine.actionDelete(this.game);
		}
	}
}
