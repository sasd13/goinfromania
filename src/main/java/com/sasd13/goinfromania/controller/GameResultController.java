package com.sasd13.goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.engine.GameEngine;
import com.sasd13.goinfromania.view.dialog.GameDialogResult;

public class GameResultController implements ActionListener {
	
	private GameDialogResult gameDialogResult;
	
	public GameResultController(GameDialogResult gameDialogResult) {
		this.gameDialogResult = gameDialogResult;
	}
	
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
		this.gameDialogResult.dispose();
		
		GameEngine.newGame();
	}

	private void actionEnd() {
		this.gameDialogResult.dispose();
		
		GameEngine.finishGameAndDisplayHome();
	}
}
