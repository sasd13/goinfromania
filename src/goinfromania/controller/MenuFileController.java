package goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFileController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("NEW".equalsIgnoreCase(command)) {
			//TODO New game
		} else if ("OPEN".equalsIgnoreCase(command)){
			//TODO List games
		} else if ("EXIT".equalsIgnoreCase(command)) {
			//TODO Exit game
		}
	}
}
