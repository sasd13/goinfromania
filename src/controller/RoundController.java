package controller;

import javax.swing.JOptionPane;

import view.round.RoundView;
import game.element.Direction;
import game.element.Element;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.food.PoisonCake;
import game.round.Result;
import game.round.Round;
import game.round.RoundCumulatedStatistics;
import game.round.State;
import game.setting.GamePad;

public class RoundController {

	private static RoundView roundView;
	private static Round round;
	
	private static GamePad gamePad;
	
	public static void initialize(RoundView myRoundView, Round myRound) {
		roundView = myRoundView;
		round = myRound;
		round.addObserver(roundView);
		roundView.update(round, null);
		
		gamePad = null;
		
		ArenaController.initialize(roundView.getArenaView(), round.getListElements());
		
		//Sauvegarde
		saveRoundInCache();
	}
	
	public static void checkRound() {
		boolean hasRoundError = false;
		
		if (round.getCountEatenCakes() > round.getMaxCountEatenCakes()) {
			hasRoundError = true;
			
			//TODO Throw exception
		}
		
		Pig pig = round.getListElements().getPig();
		
		if (pig.isDied() && !round.isFinished()) {
			hasRoundError = true;
			
			//TODO Throw exception
		}
		
		if (hasRoundError) {
			exitRound();
		}
	}
	
	public static void showDialogRoundRules() {
		String title = "Round Rules";
		String message = "Eat cakes to succeed! Be careful from enemies and bad foods...";
		
		JOptionPane.showMessageDialog(roundView, message, title, JOptionPane.OK_OPTION);
	}
	
	public static void displayRoundStarter() {
		roundView.displayRoundStarterView();
	}
	
	public static void startRound() {
		round.setState(State.STARTED);
		
		gamePad = SettingController.loadGamePad();
		
		ArenaController.start();
	}
	
	public static void showDialogConfirmRestartRound() {
		String title = "Round";
		String message = "Restart round ?";
		
		int selected = JOptionPane.showConfirmDialog(roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			restartRound();
		}
	}
	
	private static void restartRound() {
		ArenaController.stop();
		
		round.deleteObservers();
		
		round = loadRoundFromCache(round.getId());
		
		initialize(roundView, round);
		startRound();
	}
	
	public static void pauseRound() {
		round.setState(State.PAUSED);
		
		ArenaController.stop();
		
		roundView.displayRoundMenuView();
	}
	
	public static void showDialogConfirmStopRound() {
		String title = "Round";
		String message = "Confirm stop round ?";
		
		int selected = JOptionPane.showConfirmDialog(roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			stopRound();
		}
	}
	
	private static void stopRound() {
		round.setState(State.STOPPED);
		
		ArenaController.stop();
	}
	
	public static void stopRoundAndDisplayResult() {
		stopRound();
		
		Pig pig = round.getListElements().getPig();
		if (pig.isDied()) {
			round.setResult(Result.LOOSE);
		} else {
			round.setResult(Result.WIN);
		}
		
		round.deleteObservers();
		
		displayRoundResult();
	}
	
	public static void stopRoundWithoutResultAndExit() {
		stopRound();
		
		round.deleteObservers();
		
		showDialogConfirmSaveRound();
		exitRound();
	}
	
	public static boolean hasRoundStopped() {
		if (round != null && round.getState() != State.STOPPED) {
			return false;
		}
		
		return true;
	}
	
	public static void checkEatenCakes() {
		if (round.getCountEatenCakes() == round.getMaxCountEatenCakes()) {
			round.setFinished(true);
			stopRoundAndDisplayResult();
		}
	}
	
	public static void checkPigLife() {
		Pig pig = round.getListElements().getPig();
		
		if (pig.isDied()) {
			round.setFinished(true);
			stopRoundAndDisplayResult();
		}
	}
	
	public static void showDialogConfirmSaveRound() {
		String title = "Round";
		String message = "Save progress ?";
		
		int selected = JOptionPane.showConfirmDialog(roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			saveRound();
		}
	}
	
	public static void saveRound() {
		GameController.saveRound(round);
	}
	
	private static void exitRound() {
		GameController.setMenuRoundEnabled(false);
		GameController.displayHome();
	}
	
	private static void displayRoundResult() {		
		roundView.displayRoundResultView();
	}
	
	public static void openNextRound() {
		round = Round.createNextRound(round, false, true);
		
		showDialogConfirmSaveRound();
		
		GameController.openRound(round);
	}
	
	public static void finishResultAndDisplayHome() {
		if (round.getResult() == Result.WIN) {
			round = Round.createNextRound(round, false, true);
			
			showDialogConfirmSaveRound();
		}
		
		exitRound();
	}
	
	private static Round loadRoundFromCache(String roundId) {
		Round round = null;
		
		//TODO Implementation
		
		return round;
	}
	
	private static void saveRoundInCache() {
		//TODO Implementation
	}
	
	public static void actionGamePad(int keyCode) {
		if (keyCode == gamePad.getKeyStart()) {
			if (round.getState() == State.STARTED) {
				pauseRound();
			} else if (round.getState() == State.PAUSED) {
				startRound();
			} else {
				//TODO Throw exception
			}
		} else {
			Pig pig = round.getListElements().getPig();
			
			if (keyCode == gamePad.getKeyMoveLeft()) {
				ArenaController.actionMove(pig, Direction.LEFT);
			} else if (keyCode == gamePad.getKeyMoveRight()) {
				ArenaController.actionMove(pig, Direction.RIGHT);
			} else if (keyCode == gamePad.getKeyMoveUp()) {
				ArenaController.actionMove(pig, Direction.UP);
			} else if (keyCode == gamePad.getKeyMoveDown()) {
				ArenaController.actionMove(pig, Direction.DOWN);
			} else if (keyCode == gamePad.getKeyPigAttak()) {
				ArenaController.initPigAttak();
			}
		}
	}
	
	public static void cumuleFoodStatistics(Food food) {
		RoundCumulatedStatistics roundCumulatedStatistics = round.getRoundCumulatedStatistics();
		
		if (food.getName().equals(Cake.NAME)) {
			round.setCountEatenCakes(round.getCountEatenCakes() + 1);
			roundCumulatedStatistics.setTotalEatenCakes(roundCumulatedStatistics.getTotalEatenCakes() + 1);
		} else if (food.getName().equals(PoisonCake.NAME)) {
			round.setCountEatenPoisonCakes(round.getCountEatenPoisonCakes() + 1);
			roundCumulatedStatistics.setTotalEatenPoisonCakes(roundCumulatedStatistics.getTotalEatenPoisonCakes() + 1);
		}
		
		cumuleScoreStatistics(food.getScorePoint());
	}
	
	public static void cumuleEnemyStatistics(Enemy enemy) {
		RoundCumulatedStatistics roundCumulatedStatistics = round.getRoundCumulatedStatistics();
		
		if (enemy.getName().equals(Nutritionist.NAME)) {
			round.setCountNutritionistKilled(round.getCountNutritionistKilled() + 1);
			roundCumulatedStatistics.setTotalNutritionistKilled(roundCumulatedStatistics.getTotalNutritionistKilled() + 1);
		} else if (enemy.getName().equals(Virus.NAME)) {
			round.setCountVirusKilled(round.getCountVirusKilled() + 1);
			roundCumulatedStatistics.setTotalVirusKilled(roundCumulatedStatistics.getTotalVirusKilled() + 1);
		}
		
		cumuleScoreStatistics(enemy.getScorePoint());
	}
	
	private static void cumuleScoreStatistics(int scoreValue) {
		RoundCumulatedStatistics roundCumulatedStatistics = round.getRoundCumulatedStatistics();
		
		round.setScore(round.getScore() + scoreValue);
		roundCumulatedStatistics.setTotalScore(roundCumulatedStatistics.getTotalScore() + scoreValue);
	}
}