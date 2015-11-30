package goinfromania.controller.menu;

import goinfromania.controller.engine.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFileController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		GameEngine gameEngine = GameEngine.getInstance();
		
		if ("NEW".equalsIgnoreCase(command)) {
			if (gameEngine.closeIfHasGameInProgress()) {
				gameEngine.actionNew();
			}
		} else if ("LIST".equalsIgnoreCase(command)) {
			if (gameEngine.closeIfHasGameInProgress()) {
				gameEngine.actionList();
			}
		} else if ("EXIT".equalsIgnoreCase(command)) {
			if (gameEngine.closeIfHasGameInProgress()) {
				gameEngine.actionExit();
			}
		}
	}
}
