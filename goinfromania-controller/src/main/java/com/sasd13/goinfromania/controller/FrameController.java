package com.sasd13.goinfromania.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.bean.Game;

public class FrameController implements WindowListener {

	private IFrameView frameView;
	private Game game;

	public FrameController(IFrameView frameView) {
		this.frameView = frameView;
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
		if (game != null && game.getState().getOrder() < EnumState.PAUSED.getOrder()) {
			GameHandler.pauseGame(game);
		}

		FrameHandler.closeFrame(frameView, game);
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
