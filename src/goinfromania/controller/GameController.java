package goinfromania.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import goinfromania.game.Game;
import goinfromania.view.frame.GameFrame;
import goinfromania.view.frame.GameView;

public class GameController implements ActionListener, KeyListener, WindowListener {
	
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
		
		try {
			this.game.addObserver(this.gameView);
			this.gameView.update(this.game, null);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if ("NEW".equalsIgnoreCase(command)) {
			
		} else if ("OPEN".equalsIgnoreCase(command)) {
			
		} else if ("CLOSE".equalsIgnoreCase(command)) {
			
		} else if ("EXIT".equalsIgnoreCase(command)) {
			
		}
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
		showDialogConfirmExitGame();
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
	
	public void showDialogConfirmExitGame() {
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(this.gameView, message, Game.NAME, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			exitGame();
		}
	}
	
	private void exitGame() {
		//TODO
		
		this.game.deleteObservers();
		GameFrame.getInstance().dispose();
		
		System.exit(0);
	}
}
