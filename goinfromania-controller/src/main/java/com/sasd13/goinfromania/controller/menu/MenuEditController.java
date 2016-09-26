package com.sasd13.goinfromania.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.GameEngine;

public class MenuEditController implements ActionListener {
	
	public static final String COMMAND_PAUSE = "PAUSE";
	public static final String COMMAND_STOP = "STOP";
	public static final String COMMAND_SAVE = "SAVE";
	
	private GameEngine gameEngine = GameEngine.getInstance();
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("PAUSE".equalsIgnoreCase(command)) {
			actionPause();
		} else if ("STOP".equalsIgnoreCase(command)) {
			actionStop();
		} else if ("SAVE".equalsIgnoreCase(command)) {
			actionSave();
		}
	}
	
	private void actionPause() {
		gameEngine.pauseOrResumeGame();
	}
	
	private void actionStop() {
		gameEngine.stopGameSafely();
	}
	
	private void actionSave() {
		gameEngine.saveGame();
	}
}
