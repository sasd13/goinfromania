package com.sasd13.goinfromania.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.engine.GameEngine;

public class FrameController implements WindowListener {

	private IFrame frame;
	private Game game;

	public FrameController(IFrame frame) {
		this.frame = frame;
	}
	
	public void setGame(Game game) {
		this.game = game;
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
		if (frame.askClose()) {
			if (game != null && game.getState().getOrder() < EnumState.DESTROYED.getOrder()) {
				GameEngine.finishGame(game, frame);
			}
			
			frame.dispose();
			System.exit(0);
		}
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
