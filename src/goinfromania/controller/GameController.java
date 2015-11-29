package goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JOptionPane;

import goinfromania.db.GameDAO;
import goinfromania.game.Game;
import goinfromania.game.Player;
import goinfromania.view.frame.GameFrame;
import goinfromania.view.frame.GameView;
import goinfromania.view.frame.ListGamesView;

public class GameController implements ActionListener, KeyListener, WindowListener {
	
	private static GameController instance = null;

	private Game game;
	
	private ListGamesView listGamesView;
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
		
		try {
			this.game.addObserver(this.gameView);
			this.gameView.update(this.game, null);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void setListGamesView(ListGamesView listGamesView) {
		this.listGamesView = listGamesView;
	}
	
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		dispatch(null, event);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		boolean closed = true;
		
		if (hasGameInProgress()) {
			closed = actionClose();
		}
		
		if (closed) {
			actionExit();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private boolean hasGameInProgress() {
		return this.game != null;
	}
	
	private boolean actionClose() {
		String message = "Sauvegarder la partie ?";
		
		int selected = JOptionPane.showConfirmDialog(this.gameView, message, "Partie", JOptionPane.YES_NO_CANCEL_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			performSave();
			performClose();
			
			return true;
		} else if (selected == JOptionPane.NO_OPTION) {
			performClose();
			
			return true;
		}
		
		return false;
	}
	
	private void performClose() {
		clear();
		GameFrame.getInstance().displayHomeView();
	}
	
	private void performSave() {
		GameDAO.update(this.game);
	}
	
	public void dispatch(String requester, ActionEvent event) {
		boolean closed = true;
		
		if ("MENUFILE".equalsIgnoreCase(requester)) {
			if (hasGameInProgress()) {
				closed = actionClose();
			}
		}
		
		if (closed) {
			String command = event.getActionCommand();
			
			if ("NEW".equalsIgnoreCase(command)) {
				actionNew();
			} else if ("OPEN".equalsIgnoreCase(command)) {
				actionOpen();
			} else if ("EXIT".equalsIgnoreCase(command)) {
				actionExit();
			} else if ("PAUSE".equalsIgnoreCase(command)) {
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
		
		GameFrame.getInstance().displayGameView();
	}
	
	private void actionOpen() {
		List<Game> games = GameDAO.loadAll();
		
		this.listGamesView.setGames(games);
		
		GameFrame.getInstance().displayListGamesView();
	}
	
	private void actionExit() {
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(this.gameView, message, Game.NAME, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
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
