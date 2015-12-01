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
		this.frame.setMenuEditEnabled(false);
		this.frame.displayHomeView();
	}
	
	public void displayListGames() {
		List<Game> games = GameDAO.loadAll();
		
		this.frame.getListGamesView().setGames(games);
		this.frame.setMenuEditEnabled(false);
		this.frame.displayListGamesView();
	}
	
	public void displayGame(Game game) {
		game.addObserver(this.frame.getGameView());
		game.addObserver(this.frame.getGameView().getArenaView());
		
		this.frame.setMenuEditEnabled(true);
		this.frame.displayGameView();
	}
	
	@Override
	public void windowActivated(WindowEvent event) {
		//Do nothing
	}

	@Override
	public void windowClosed(WindowEvent event) {
		//Do nothing
	}

	@Override
	public void windowClosing(WindowEvent event) {
		if (GameEngine.stopGameSafely()) {
			GameEngine.exitGame();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent event) {
		//Do nothing
	}

	@Override
	public void windowDeiconified(WindowEvent event) {
		//Do nothing
	}

	@Override
	public void windowIconified(WindowEvent event) {
		//Do nothing
	}

	@Override
	public void windowOpened(WindowEvent event) {
		//Do nothing
	}
}
