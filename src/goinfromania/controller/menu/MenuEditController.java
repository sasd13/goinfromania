package goinfromania.controller.menu;

import goinfromania.controller.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEditController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		GameEngine gameEngine = GameEngine.getInstance();
		
		if ("PAUSE".equalsIgnoreCase(command)) {
			gameEngine.actionPause();
		} else if ("STOP".equalsIgnoreCase(command)) {
			gameEngine.actionStop();
		} else if ("SAVE".equalsIgnoreCase(command)) {
			gameEngine.actionSave();
		}
	}
}
