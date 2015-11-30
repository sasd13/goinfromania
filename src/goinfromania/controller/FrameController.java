package goinfromania.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import goinfromania.controller.engine.GameEngine;
import goinfromania.db.GameDAO;
import goinfromania.game.Game;
import goinfromania.view.frame.Frame;

public class FrameController implements WindowListener {
	
	private Frame frame;
	
	public FrameController(Frame frame) {
		this.frame = frame;
		
		GameEngine.setFrameController(this);
	}
	
	public void displayHome() {
		this.frame.displayHomeView();
	}
	
	public void displayListGames() {
		List<Game> games = GameDAO.loadAll();
		
		this.frame.getListGamesView().setGames(games);
		this.frame.displayListGamesView();
	}
	
	public void displayGame(Game game) {
		game.addObserver(this.frame.getGameView());
		game.addObserver(this.frame.getGameView().getArenaView());
		
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
		if (GameEngine.closeIfHasGameInProgress()) {
			GameEngine.actionExit();
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
