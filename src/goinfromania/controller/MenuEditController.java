package goinfromania.controller;

import java.awt.event.ActionEvent;

public class MenuEditController extends MenuController {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("PAUSE".equalsIgnoreCase(command)) {
			//TODO New game
		} else if ("STOP".equalsIgnoreCase(command)){
			//TODO List games
		} else if ("SAVE".equalsIgnoreCase(command)) {
			//TODO Exit game
		}
	}
}
