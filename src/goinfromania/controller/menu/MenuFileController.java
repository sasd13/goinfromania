package goinfromania.controller.menu;

import goinfromania.engine.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFileController implements ActionListener {
	
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
		if (GameEngine.stopGameSafely()) {
			GameEngine.newGame();
		}
	}

	private void actionList() {
		if (GameEngine.stopGameSafely()) {
			GameEngine.listGames();
		}
	}

	private void actionExit() {
		if (GameEngine.stopGameSafely()) {
			GameEngine.exitGame();
		}
	}
}
