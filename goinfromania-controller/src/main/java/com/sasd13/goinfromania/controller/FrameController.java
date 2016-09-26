package com.sasd13.goinfromania.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.dao.GameDAO;

public class FrameController implements WindowListener {
	
	private GameEngine gameEngine = GameEngine.getInstance();
	
	public void displayHome() {
		/*this.frame.setMenuEditEnabled(false);
		this.frame.displayHomeView();*/
	}
	
	public void displayListGames() {
		List<Game> games = GameDAO.loadAll();
		
		/*this.frame.getListGamesView().setGames(games);
		this.frame.setMenuEditEnabled(false);
		this.frame.displayListGamesView();*/
	}
	
	public void displayGame(Game game) {
		/*game.addObserver(this.frame.getGameView());
		game.addObserver(this.frame.getGameView().getArenaView());
		
		this.frame.setMenuEditEnabled(true);
		this.frame.displayGameView();*/
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
		if (gameEngine.stopGameSafely()) {
			gameEngine.exitGame();
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
