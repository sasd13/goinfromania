package com.sasd13.goinfromania.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.GameEngine;

public class MenuFileController implements ActionListener {
	
	private GameEngine gameEngine = GameEngine.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("NEW".equalsIgnoreCase(command)) {
			actionNew();
		} else if ("LIST".equalsIgnoreCase(command)) {
			actionList();
		} else if ("EXIT".equalsIgnoreCase(command)) {
			actionExit();
		}
	}

	private void actionNew() {
		if (gameEngine.stopGameSafely()) {
			gameEngine.newGame();
		}
	}

	private void actionList() {
		if (gameEngine.stopGameSafely()) {
			//FrameController.displayListGames();
		}
	}

	private void actionExit() {
		if (gameEngine.stopGameSafely()) {
			gameEngine.exitGame();
		}
	}
}
