package goinfromania.controller;

import goinfromania.controller.engine.GameEngine;
import goinfromania.game.Game;
import goinfromania.view.dialog.GameDialogResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameResultController implements ActionListener {
	
	private Game game;
	
	private GameDialogResult gameDialogResult;
	
	public GameResultController(GameDialogResult gameDialogResult) {
		this.gameDialogResult = gameDialogResult;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		GameEngine gameEngine = GameEngine.getInstance();
		
		if ("REPLAY".equalsIgnoreCase(command)) {
			this.gameDialogResult.dispose();
			
			gameEngine.actionNew();
		} else if ("END".equalsIgnoreCase(command)) {
			this.gameDialogResult.dispose();
			
			gameEngine.actionStop();
		}
	}
}
