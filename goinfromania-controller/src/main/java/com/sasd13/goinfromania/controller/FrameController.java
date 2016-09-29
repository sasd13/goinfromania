package com.sasd13.goinfromania.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameController implements WindowListener {

	private IFrame frame;

	public FrameController(IFrame frame) {
		this.frame = frame;
	}

	@Override
	public void windowActivated(WindowEvent event) {
		// Do nothing
	}

	@Override
	public void windowClosed(WindowEvent event) {
		// Do nothing
	}

	@Override
	public void windowClosing(WindowEvent event) {
		GameEngine gameEngine = GameEngine.getInstance();
		
		if (gameEngine.hasGameInProgress()) {
			gameEngine.onPause();
			gameEngine.onStop();
			gameEngine.onDestroy();
		}
		
		frame.close();
	}

	@Override
	public void windowDeactivated(WindowEvent event) {
		// Do nothing
	}

	@Override
	public void windowDeiconified(WindowEvent event) {
		// Do nothing
	}

	@Override
	public void windowIconified(WindowEvent event) {
		// Do nothing
	}

	@Override
	public void windowOpened(WindowEvent event) {
		// Do nothing
	}
}
