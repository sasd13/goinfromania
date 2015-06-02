package controller;

import javax.swing.JOptionPane;

import pattern.dao.SettingDAO;
import view.round.RoundView;
import game.element.Direction;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.food.PoisonCake;
import game.round.Result;
import game.round.Round;
import game.round.Statistics;
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
		
		saveRoundInCache();
		loadGamePad();
		
		ArenaController.initialize(roundView.getRoundArenaView(), round.getListElements(), round.getLevel(), round.getRoundNumber());
	}
	
	public static void displayRoundStarter() {
		roundView.displayRoundStarterView();
	}
	
	public static void startRound() {
		round.setState(State.START);
		
		ArenaController.start();
	}
	
	public static void loadGamePad() {
		gamePad = (GamePad) SettingDAO.load(GamePad.NAME);
	}
	
	public static void showDialogConfirmRestartRound() {
		String title = "Partie";
		String message = "Recommencer la partie ?";
		
		int selected = JOptionPane.showConfirmDialog(roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			stopRound();
			restartRound();
		}
	}
	
	private static void restartRound() {
		round.deleteObservers();
		
		round = loadRoundFromCache(round.getId());
		
		GameController.openRound(round);
	}
	
	public static void pauseRound() {
		round.setState(State.PAUSE);
		
		ArenaController.pause();
	}
	
	public static void showDialogConfirmStopRound() {
		String title = "Partie";
		String message = "Arrêter la partie ?";
		
		int selected = JOptionPane.showConfirmDialog(roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			stopRoundWithoutResultAndExit();
		}
	}
	
	private static void stopRound() {
		round.setState(State.STOP);
		
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
		if (round == null || round.getState() == State.STOP) {
			return true;
		}
		
		return false;
	}
	
	public static void checkEatenCakes() {
		Statistics statistics = round.getStatistics();
		
		if (statistics.getCountEatenCakes() == statistics.getMaxCakesToEat()) {
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
	
	public static void checkListElementsSize() {
		if (round.getListElements().size() == Round.MAX_ELEMENT) {
			round.setFinished(true);
			stopRoundAndDisplayResult();
		}
	}
	
	public static void showDialogConfirmSaveRound() {
		String title = "Partie";
		String message = "Sauvegarder la progression ?";
		
		int selected = JOptionPane.showConfirmDialog(roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			saveRound();
		}
	}
	
	public static void saveRound() {
		GameController.saveRound(round);
	}
	
	private static void exitRound() {
		round = null;
		GameController.setMenuRoundEnabled(false);
		GameController.displayHome();
	}
	
	private static void displayRoundResult() {		
		roundView.displayRoundResultView();
	}
	
	public static void openNextRound() {
		GameController.removeRound(round);
		
		round = createNextRound(round);
		
		GameController.openRound(round);
	}
	
	private static Round createNextRound(Round round) {
		Round nextRound = new Round();
		
		nextRound.setRoundNumber(round.getRoundNumber() + 1);
		nextRound.setLevel(round.getLevel());
		nextRound.setDateCreated(round.getDateCreated());
		
		Pig pig = round.getListElements().getPig();
		Pig newPig = new Pig();
		newPig.setLife(pig.getLife());
		newPig.setEnergy(pig.getEnergy());
		nextRound.getListElements().add(newPig);
		
		Statistics statistics = round.getStatistics();
		statistics.resetCounts();
		statistics.setMaxCakesToEat(statistics.getMaxCakesToEat() + Statistics.INCREMENTAL_CAKES_TO_EAT);
		nextRound.setStatistics(statistics);
		
		return nextRound;
	}
	
	public static void finishResultAndDisplayHome() {
		if (round.getResult() == Result.WIN) {
			round = createNextRound(round);
			
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
			if (round.getState() == State.START) {
				pauseRound();
			} else if (round.getState() == State.PAUSE) {
				startRound();
			} else {
				//TODO Throw exception
			}
		} else if (round.getState() == State.START) {
			Pig pig = round.getListElements().getPig();
			
			if (keyCode == gamePad.getKeyMoveNorth()) {
				ArenaController.actionMove(pig, Direction.NORTH);
			} else if (keyCode == gamePad.getKeyMoveSouth()) {
				ArenaController.actionMove(pig, Direction.SOUTH);
			} else if (keyCode == gamePad.getKeyMoveWest()) {
				ArenaController.actionMove(pig, Direction.WEST);
			} else if (keyCode == gamePad.getKeyMoveEast()) {
				ArenaController.actionMove(pig, Direction.EAST);
			} else if (keyCode == gamePad.getKeyPigAttak()) {
				ArenaController.initPigAttak();
			}
		}
	}
	
	public static void cumuleFoodStatistics(Food food) {
		Statistics statistics = round.getStatistics();
		
		if (food instanceof Cake) {
			statistics.setCountEatenCakes(statistics.getCountEatenCakes() + 1);
			statistics.setTotalEatenCakes(statistics.getTotalEatenCakes() + 1);
		} else if (food instanceof PoisonCake) {
			statistics.setCountEatenPoisonCakes(statistics.getCountEatenPoisonCakes() + 1);
			statistics.setTotalEatenPoisonCakes(statistics.getTotalEatenPoisonCakes() + 1);
		}
		
		cumuleScoreStatistics(food.getScorePoint());
	}
	
	public static void cumuleEnemyStatistics(Enemy enemy) {
		Statistics statistics = round.getStatistics();
		
		if (enemy.getName().equals(Nutritionist.NAME)) {
			statistics.setCountKilledNutritionists(statistics.getCountKilledNutritionists() + 1);
			statistics.setTotalKilledNutritionists(statistics.getTotalKilledNutritionists() + 1);
		} else if (enemy.getName().equals(Virus.NAME)) {
			statistics.setCountKilledViruses(statistics.getCountKilledViruses() + 1);
			statistics.setTotalKilledViruses(statistics.getTotalKilledViruses() + 1);
		}
		
		cumuleScoreStatistics(enemy.getScorePoint());
	}
	
	private static void cumuleScoreStatistics(int scoreValue) {
		Statistics statistics = round.getStatistics();
		
		statistics.setScore(statistics.getScore() + scoreValue);
	}
}