package goinfromania.controller.menu;

import goinfromania.controller.engine.GameEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEditController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("PAUSE".equalsIgnoreCase(command)) {
			GameEngine.actionPause();
		} else if ("STOP".equalsIgnoreCase(command)) {
			GameEngine.actionStop();
		} else if ("SAVE".equalsIgnoreCase(command)) {
			GameEngine.actionSave();
		}
	}
}
