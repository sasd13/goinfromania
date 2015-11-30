package goinfromania.controller;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;

import goinfromania.db.GameDAO;
import goinfromania.game.Game;
import goinfromania.game.Player;
import goinfromania.view.frame.GameView;
import goinfromania.view.frame.ListGamesView;

public class GameManager {
	
	private static GameManager instance = null;
	
	private Game game;
	
	private GameView gameView;
	private ListGamesView listGamesView;
	
	private FrameController frameController;
	
	private GameManager() {}
	
	public static synchronized GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		
		return instance;
	}
	
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	public void setListGamesView(ListGamesView listGamesView) {
		this.listGamesView = listGamesView;
	}
	
	public void setFrameController(FrameController frameController) {
		this.frameController = frameController;
	}
	
	public boolean closeIfHasGameInProgress() {
		boolean closed = true;
		
		if (hasGameInProgress()) {
			closed = actionClose();
		}
		
		return closed;
	}
	
	private boolean hasGameInProgress() {
		return this.game != null;
	}
	
	private boolean actionClose() {
		String message = "Sauvegarder la partie ?";
		
		int selected = JOptionPane.showConfirmDialog(this.gameView, message, "Partie", JOptionPane.YES_NO_CANCEL_OPTION);
		
		switch (selected) {
			case JOptionPane.YES_OPTION:
				performSave();
				performClose();
				return true;
			case JOptionPane.NO_OPTION:
				performClose();
				return true;
			default:
				return false;
		}
	}
	
	private void performClose() {
		clear();
		this.frameController.displayHome();
	}
	
	private void performSave() {
		GameDAO.update(this.game);
	}
	
	public void dispatch(String requester, ActionEvent event) {
		if ("MENUFILE".equalsIgnoreCase(requester)
				|| "RESULTDIALOG".equalsIgnoreCase(requester)) {
			if (closeIfHasGameInProgress()) {
				String command = event.getActionCommand();
				
				if ("NEW".equalsIgnoreCase(command)) {
					actionNew();
				} else if ("OPEN".equalsIgnoreCase(command)) {
					actionOpen();
				}
			}
		} else if ("MENUEDIT".equalsIgnoreCase(requester)) {
			String command = event.getActionCommand();
			
			if ("PAUSE".equalsIgnoreCase(command)) {
				actionPause();
			} else if ("STOP".equalsIgnoreCase(command)) {
				actionStop();
			} else if ("SAVE".equalsIgnoreCase(command)) {
				actionSave();
			}
		}
	}
	
	private void actionNew() {
		Player player = new Player("Joueur");
		
		this.game = new Game();
		this.game.setPlayer(player);
		this.game.addObserver(this.gameView);
		
		this.gameView.update(this.game, null);
		
		this.frameController.displayGame();
	}
	
	private void actionOpen() {
		List<Game> games = GameDAO.loadAll();
		
		this.listGamesView.setGames(games);
		
		this.frameController.displayListGames();
	}
	
	private void actionPause() {
		//TODO
	}
	
	private void actionStop() {
		actionClose();
	}
	
	private void actionSave() {
		performSave();
	}
	
	private void clear() {
		this.game.deleteObservers();
		this.game = null;
	}
}
