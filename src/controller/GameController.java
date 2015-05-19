package controller;

import java.util.Date;

import javax.swing.JOptionPane;

import view.GameView;
import view.round.RoundView;
import db.RoundDAO;
import game.Game;
import game.menu.GameMenuBar;
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
	}
	
	public static void startGame() {
		ListRounds listRounds = RoundDAO.loadAll();
		game.setListRounds(listRounds);
		
		displayHome();
		
		gameView.pack();
		//To center the frame on screen, must be called after pack()
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
		boolean roundStopped = RoundController.hasRoundStopped();
		if (!roundStopped) {
			RoundController.stopRoundWithoutResultAndExit();
		}
		
		game.deleteObservers();
		gameView.dispose();
	}
	
	public static boolean stopRoundIfStarted() {
		boolean roundStopped = RoundController.hasRoundStopped();
		if (roundStopped) {
			return true;
		}
		
		RoundController.showDialogConfirmStopRound();
		
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
	
	public static void displayListScores() {
		gameView.displayListScoresView();
	}
	
	public static void newRound() {
		Round round = Round.getNewInstance();
		
		openRound(round);
	}
	
	public static void openRound(Round round) {
		RoundView roundView = gameView.getRoundView();
		RoundController.initialize(roundView, round);
		
		setMenuRoundEnabled(true);
		displayRound();
		
		if (round.getRoundNumber() == 1) {
			RoundController.showDialogRoundRules();
		}
		RoundController.displayRoundStarter();
		RoundController.startRound();
	}
	
	public static void setMenuRoundEnabled(boolean enabled) {
		((GameMenuBar) gameView.getJMenuBar()).setMenuRoundEnabled(enabled);
	}
	
	public static void saveRound(Round round) {
		round.setUpdatedAt(new Date(System.currentTimeMillis()));
		game.getListRounds().add(round);
		RoundDAO.save(round);
	}
	
	public static void removeRound(Round round) {
		game.getListRounds().remove(round);
		RoundDAO.remove(round);
	}
}
