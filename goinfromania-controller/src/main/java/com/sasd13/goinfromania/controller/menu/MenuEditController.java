package com.sasd13.goinfromania.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sasd13.goinfromania.controller.engine.GameEngine;

public class MenuEditController implements ActionListener {
	
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
		GameEngine.pauseOrResumeGame();
	}
	
	private void actionStop() {
		GameEngine.stopGameSafely();
	}
	
	private void actionSave() {
		GameEngine.saveGame();
	}
}
