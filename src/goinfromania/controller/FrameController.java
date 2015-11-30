package goinfromania.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import goinfromania.controller.engine.GameEngine;
import goinfromania.view.frame.Frame;

public class FrameController implements WindowListener {
	
	private Frame frame;
	
	private GameEngine gameEngine;
	
	public FrameController(Frame frame) {
		this.frame = frame;
		
		setGameEngine();
	}

	private void setGameEngine() {
		this.gameEngine = GameEngine.getInstance();
		this.gameEngine.setFrameController(this);
		this.gameEngine.setGameView(this.frame.getGameView());
		this.gameEngine.setListGamesView(this.frame.getListGamesView());
	}
	
	public void displayHome() {
		this.frame.displayHomeView();
	}
	
	public void displayListGames() {
		this.frame.displayListGamesView();
	}
	
	public void displayGame() {
		this.frame.displayGameView();
	}
	
	@Override
	public void windowActivated(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent event) {
		if (this.gameEngine.closeIfHasGameInProgress()) {
			this.gameEngine.actionExit();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent event) {
		// TODO Auto-generated method stub
		
	}
}
