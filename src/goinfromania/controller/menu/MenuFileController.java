package goinfromania.controller.menu;

import goinfromania.controller.engine.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFileController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("NEW".equalsIgnoreCase(command)) {
			if (GameEngine.closeIfHasGameInProgress()) {
				GameEngine.actionNew();
			}
		} else if ("LIST".equalsIgnoreCase(command)) {
			if (GameEngine.closeIfHasGameInProgress()) {
				GameEngine.actionList();
			}
		} else if ("EXIT".equalsIgnoreCase(command)) {
			if (GameEngine.closeIfHasGameInProgress()) {
				GameEngine.actionExit();
			}
		}
	}
}
