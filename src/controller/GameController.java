package controller;

import java.util.Date;

import javax.swing.JOptionPane;

import pattern.dao.RoundDAO;
import view.GameView;
import view.menu.GameMenuBar;
import view.round.RoundView;
import game.Game;
import game.round.Level;
import game.round.ListRounds;
import game.round.Round;

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
		String message = "Confirm exit game ?";
		
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
		String title = "New round";
		String message = "Choose your level :";
		
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
