package goinfromania.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import goinfromania.game.Game;
import goinfromania.view.frame.Frame;

public class FrameController implements WindowListener {
	
	private Frame frame;
	
	private GameManager gameManager;
	
	public FrameController(Frame frame) {
		this.frame = frame;
		
		this.gameManager = GameManager.getInstance();
		this.gameManager.setFrameController(this);
		this.gameManager.setGameView(this.frame.getGameView());
		this.gameManager.setListGamesView(this.frame.getListGamesView());
	}
	
	public void displayFrame() {
		displayHome();
		
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
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
	
	public void actionExit() {
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(this.frame, message, Game.NAME, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
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
		if (this.gameManager.closeIfHasGameInProgress()) {
			actionExit();
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
