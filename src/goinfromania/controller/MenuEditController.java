package goinfromania.controller;

import java.awt.event.ActionEvent;

public class MenuEditController extends MenuController {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("PAUSE".equalsIgnoreCase(command)) {
			//TODO Pause game
		} else if ("STOP".equalsIgnoreCase(command)){
			//TODO Stop game
		} else if ("SAVE".equalsIgnoreCase(command)) {
			//TODO Save game
		}
	}
}
