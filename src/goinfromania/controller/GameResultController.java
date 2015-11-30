package goinfromania.controller;

import goinfromania.controller.engine.GameEngine;
import goinfromania.view.dialog.GameDialogResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameResultController implements ActionListener {
	
	private GameDialogResult gameDialogResult;
	
	public GameResultController(GameDialogResult gameDialogResult) {
		this.gameDialogResult = gameDialogResult;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("REPLAY".equalsIgnoreCase(command)) {
			this.gameDialogResult.dispose();
			
			GameEngine.actionNew();
		} else if ("END".equalsIgnoreCase(command)) {
			this.gameDialogResult.dispose();
			
			GameEngine.actionStop();
		}
	}
}
