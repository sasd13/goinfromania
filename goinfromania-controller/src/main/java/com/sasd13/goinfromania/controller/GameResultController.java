package com.sasd13.goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameResultController implements ActionListener {
	
	private GameEngine gameEngine = GameEngine.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("REPLAY".equalsIgnoreCase(command)) {
			actionReplay();
		} else if ("END".equalsIgnoreCase(command)) {
			actionEnd();
		}
	}

	private void actionReplay() {
		//this.gameDialogResult.dispose();
		
		gameEngine.newGame();
	}

	private void actionEnd() {
		//this.gameDialogResult.dispose();
		
		gameEngine.finishGameAndDisplayHome();
		//FrameController.displayHome();
	}
}
