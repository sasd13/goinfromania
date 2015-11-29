package goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import goinfromania.game.Game;
import goinfromania.view.frame.GameView;

public class GameController implements ActionListener {
	
	private static GameController instance = null;

	private Game game;
	private GameView gameView;
	
	private GameController() {}
	
	public static synchronized GameController getInstance() {
		if (instance == null) {
			instance = new GameController();
		}
		
		return instance;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("NEW".equalsIgnoreCase(command)) {
			
		} else if ("OPEN".equalsIgnoreCase(command)) {
			
		} else if ("EXIT".equalsIgnoreCase(command)) {
			
		} else if ("CLOSE".equalsIgnoreCase(command)) {
			
		}
	}
}
