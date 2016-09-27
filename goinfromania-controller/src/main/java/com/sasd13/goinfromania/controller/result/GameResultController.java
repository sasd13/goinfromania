package com.sasd13.goinfromania.controller.result;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.GameEngine;

public class GameResultController implements ActionListener {
	
	public static final String COMMAND_REPLAY = "REPLAY";
	public static final String COMMAND_END = "END";
	
	private GameEngine gameEngine = GameEngine.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (COMMAND_REPLAY.equalsIgnoreCase(command)) {
			actionReplay();
		} else if (COMMAND_END.equalsIgnoreCase(command)) {
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
