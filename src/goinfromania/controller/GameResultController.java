package goinfromania.controller;

import goinfromania.view.dialog.GameDialogResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameResultController implements ActionListener {
	
	private GameDialogResult dialog;
	
	public GameResultController(GameDialogResult dialog) {
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		GameEngine gameEngine = GameEngine.getInstance();
		
		if ("REPLAY".equalsIgnoreCase(command)) {
			this.dialog.dispose();
			
			gameEngine.actionNew();
		} else if ("END".equalsIgnoreCase(command)) {
			this.dialog.dispose();
			
			gameEngine.actionStop();
		}
	}
}
