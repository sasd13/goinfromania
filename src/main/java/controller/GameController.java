package main.java.controller;

import java.util.Date;

import javax.swing.JOptionPane;

import main.java.game.Game;
import main.java.game.round.Level;
import main.java.game.round.ListRounds;
import main.java.game.round.Round;
import main.java.pattern.dao.RoundDAO;
import main.java.view.GameView;
import main.java.view.menu.GameMenuBar;
import main.java.view.round.RoundView;

public class GameController {

	private static GameView gameView;
	private static Game game;
	
	public static void initialize() {
		gameView = GameView.getInstance();
		game = Game.getInstance();
		game.addObserver(gameView);
		gameView.update(game, null);
		
		loadListRounds();
	}
	
	public static void loadListRounds() {
		ListRounds listRounds = RoundDAO.loadAll();
		game.setListRounds(listRounds);
	}
	
	public static void startGame() {		
		displayHome();
		
		gameView.pack();
		gameView.setLocationRelativeTo(null);
		gameView.setVisible(true);
	}
	
	public static void showDialogConfirmExitGame() {
		String title = Game.NAME;
		String message = "Quitter le jeu ?";
		
		int selected = JOptionPane.showConfirmDialog(gameView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			exitGame();
		}
	}
	
	private static void exitGame() {
		if (!RoundController.hasRoundStopped()) {
			RoundController.stopRoundWithoutResultAndExit();
		}
		
		game.deleteObservers();
		gameView.dispose();
		
		System.exit(0);
	}
	
	public static boolean stopRoundIfStarted() {
		if (!RoundController.hasRoundStopped()) {
			RoundController.showDialogConfirmStopRound();
		}
		
		return RoundController.hasRoundStopped();
	}
	
	public static void displayHome() {
		gameView.displayHomeView();
	}
	
	public static void displayRound() {
		gameView.displayRoundView();
	}
	
	public static void displayListRounds() {
		gameView.displayListRoundsView();
	}
	
	public static void newRound() {
		Round round = new Round();
		
		showDialogChooseRoundLevel(round);
	}
	
	public static void showDialogChooseRoundLevel(Round round) {
		String title = "Nouvelle partie";
		String message = "Choisir le niveau";
		
		int selected = JOptionPane.showOptionDialog(gameView, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Level.values(), Level.EASY);
		if (selected != JOptionPane.CLOSED_OPTION) {
			if (selected == 2) {
				round.setLevel(Level.HARD);
			} else if (selected == 1) {
				round.setLevel(Level.NORMAL);
			} else {
				round.setLevel(Level.EASY);
			}
			
			openRound(round);
		}
	}
	
	public static void openRound(Round round) {
		RoundView roundView = gameView.getRoundView();
		RoundController.initialize(roundView, round);
		
		setMenuRoundEnabled(true);
		displayRound();
		
		RoundController.displayRoundStarter();
		RoundController.startRound();
	}
	
	public static void setMenuRoundEnabled(boolean enabled) {
		((GameMenuBar) gameView.getJMenuBar()).setMenuRoundEnabled(enabled);
	}
	
	public static void saveRound(Round round) {
		round.setDateUpdated(new Date(System.currentTimeMillis()));
		game.getListRounds().add(round);
		
		RoundDAO.save(round);
	}
	
	public static void removeRound(Round round) {
		game.getListRounds().remove(round);
		
		RoundDAO.remove(round);
	}
}
