package goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameResultController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("REPLAY".equalsIgnoreCase(command)) {
			
		} else if ("END".equalsIgnoreCase(command)) {
			
		}
	}
}
