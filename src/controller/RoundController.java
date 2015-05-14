package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import main.Test;
import view.round.RoundView;
import game.animation.MoveListener;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.food.PoisonCake;
import game.element.power.Power;
import game.round.Result;
import game.round.Round;
import game.round.RoundCumulatedStatistics;
import game.round.State;
import game.setting.GamePad;
import game.util.ArenaUtil;
import game.util.ThreadSleeper;

public class RoundController {

	private RoundView roundView;
	private Round round;
	
	private GamePad gamePad;
	
	public RoundController(RoundView roundView, Round round) {
		this.roundView = roundView;
		this.round = round;
		this.round.addObserver(this.roundView);
		this.roundView.update(this.round, null);
		
		this.gamePad = null;
		
		//Sauvegarde
		saveRoundInCache();
		
		//Remplissage
		if (this.round.getUpdatedAt() == null) {
			Test.testArena(this.round.getListElements());
		}
	}
	
	private void checkRound() {
		boolean hasRoundError = false;
		
		if (this.round.getCountEatenCakes() > this.round.getMaxCountEatenCakes()) {
			hasRoundError = true;
			
			//TODO Throw exception
		}
		
		Pig pig = this.round.getListElements().getPig();
		
		if (pig.isDied() && !round.isFinished()) {
			hasRoundError = true;
			
			//TODO Throw exception
		}
		
		if (hasRoundError) {
			exitRound();
		}
	}
	
	public void showDialogRoundRules() {
		String title = "Round Rules";
		String message = "Eat cakes to succeed! Be careful from enemies and bad foods...";
		
		JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
	}
	
	public void displayRoundStarter() {
		this.roundView.displayRoundStarterView();
	}
	
	public void startRound() {
		this.round.setState(State.STARTED);
		
		this.gamePad = SettingController.getInstance().loadGamePad();
		
		this.roundView.requestFocusOnArenaView();
		
		Pig pig = this.round.getListElements().getPig();
		startMoveAnimation(pig);
	}
	
	public void showDialogConfirmRestartRound() {
		String title = "Round";
		String message = "Restart round ?";
		
		int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			restartRound();
		}
	}
	
	private void restartRound() {
		endUpdateRoundObservers();
		
		this.round = loadRoundFromCache(this.round.getId());
		this.round.addObserver(this.roundView);
		this.roundView.update(this.round, null);
		
		startRound();
	}
	
	private void endUpdateRoundObservers() {
		this.round.deleteObservers();
	}
	
	public void pauseRound() {
		this.round.setState(State.PAUSED);
		
		//TODO
		
		this.roundView.displayRoundMenuView();
	}
	
	public void showDialogConfirmStopRound() {
		String title = "Round";
		String message = "Confirm stop round ?";
		
		int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			stopRound();
		}
	}
	
	private void stopRound() {
		this.round.setState(State.STOPPED);
		
		//TODO Implementation
		
		if (!this.round.isFinished()) {
			endUpdateRoundObservers();
			
			showDialogConfirmSaveRound();
			exitRound();
		} else {
			Pig pig = this.round.getListElements().getPig();
			if (pig.isDied()) {
				this.round.setResult(Result.LOOSE);
			} else {
				this.round.setResult(Result.WIN);
			}
			
			endUpdateRoundObservers();
			
			displayRoundResult();
		}
	}
	
	public void showDialogConfirmSaveRound() {
		String title = "Round";
		String message = "Save progress ?";
		
		int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			saveRound();
		}
	}
	
	public void saveRound() {
		GameController.getInstance().saveRound(this.round);
	}
	
	private void exitRound() {
		GameController.getInstance().setMenuRoundEnabled(false);
		GameController.getInstance().displayHome();
	}
	
	private void displayRoundResult() {		
		this.roundView.displayRoundResultView();
	}
	
	public boolean isRoundStopped() {
		if (this.round.getState() == State.STOPPED) {
			return true;
		}
		
		return false;
	}
	
	public void openNextRound() {
		this.round = Round.createNextRound(this.round, false, true);
		
		showDialogConfirmSaveRound();
		
		GameController.getInstance().openRound(this.round);
	}
	
	public void finishResultAndDisplayHome() {
		if (this.round.getResult() == Result.WIN) {
			this.round = Round.createNextRound(this.round, false, true);
			
			showDialogConfirmSaveRound();
		}
		
		exitRound();
	}
	
	private Round loadRoundFromCache(String roundId) {
		Round round = null;
		
		//TODO Implementation
		
		return round;
	}
	
	private void saveRoundInCache() {
		//TODO Implementation
	}
	
	public void updateArena() {
		this.roundView.updateArenaView();
	}
	
	public void actionGamePad(int keyCode) {
		if (keyCode == this.gamePad.getKeyStart()) {
			if (this.round.getState() == State.STARTED) {
				pauseRound();
			} else if (this.round.getState() == State.PAUSED) {
				startRound();
			} else {
				//TODO Throw exception
			}
		} else {
			Pig pig = this.round.getListElements().getPig();
			
			if (keyCode == this.gamePad.getKeyMoveLeft()) {
				actionMove(pig, Direction.LEFT);
			} else if (keyCode == this.gamePad.getKeyMoveRight()) {
				actionMove(pig, Direction.RIGHT);
			} else if (keyCode == this.gamePad.getKeyMoveUp()) {
				actionMove(pig, Direction.UP);
			} else if (keyCode == this.gamePad.getKeyMoveDown()) {
				actionMove(pig, Direction.DOWN);
			} else if (keyCode == this.gamePad.getKeyPigAttak()) {
				initPigAttak();
			}
		}
	}
	
	public void actionMove(Element elementActor, Direction direction) {
		ListElements listElements = this.round.getListElements();
		
		boolean canMove = ArenaUtil.canMove(elementActor, direction, listElements);
		if (canMove) {
			elementActor.move(direction);
			updateArena();
			
			ListElements listElementsInTouch = ArenaUtil.getElementsInTouch(elementActor, this.round.getListElements());
			
			for (int i=0; i<listElementsInTouch.size(); i++) {
				actionInTouch(elementActor, listElementsInTouch.get(i));
			}
		}
	}
	
	private void actionInTouch(Element elementActor, Element elementInTouch) {
		boolean canAct = ArenaUtil.canActInTouch(elementActor, elementInTouch);
		if (canAct) {
			if (elementActor instanceof Pig) {
				Pig pig = (Pig) elementActor;
				
				if (elementInTouch instanceof Enemy) {
					Enemy enemy = (Enemy) elementInTouch;
					
					if (enemy.isPowerful()) {
						actionEnemyAttaksPig(enemy, enemy.getPower());
					}
				} else if (elementInTouch instanceof Food) {
					if (pig.isGreedy()) {
						actionPigEatsFood((Food) elementInTouch);
					}
				}
			} else if (elementActor instanceof Enemy) {
				Enemy enemy = (Enemy) elementActor;
				
				if (elementInTouch instanceof Pig) {
					if (enemy.isPowerful()) {
						actionEnemyAttaksPig(enemy, enemy.getPower());
					}
				}
			}
		}
	}
	
	private void actionEnemyAttaksPig(Enemy enemy, Power power) {		
		Pig pig = this.round.getListElements().getPig();
		
		power.act(pig);
		enemy.setPowerlessForDelay();
		
		if (pig.isDied()) {
			this.round.setFinished(true);
			stopRound();
		}
	}
	
	private void actionPigEatsFood(Food food) {
		Pig pig = this.round.getListElements().getPig();
		
		food.setEated(true);
		food.act(pig);
		
		removeElement(food);
		cumuleStatistics(food);
		
		if (food.getName().equals(Cake.NAME) 
				&& this.round.getCountEatenCakes() == this.round.getMaxCountEatenCakes()) {
			this.round.setFinished(true);
			stopRound();
		}
	}
	
	private void initPigAttak() {
		boolean hasAttakedNextTo = actionPigAttaksNextTo();
		if (!hasAttakedNextTo) {
			actionPigAttaksAfar();
		}
	}
	
	private boolean actionPigAttaksNextTo() {
		Pig pig = this.round.getListElements().getPig();
		
		ListElements listElementsNextTo = ArenaUtil.getElementsNextTo(pig, this.round.getListElements());
		if (listElementsNextTo.isEmpty()) {
			return false;
		}
		
		Element elementNextTo;
		for (int i=0; i<listElementsNextTo.size(); i++) {
			elementNextTo = listElementsNextTo.get(i);
			
			if (elementNextTo instanceof Enemy && pig.isPowerful()) {
				actionPigAttaksEnemy((Enemy) elementNextTo, pig.getPowerWithEnergy());
			}
		}
		
		return true;
	}
	
	private boolean actionPigAttaksAfar() {
		Pig pig = this.round.getListElements().getPig();
		
		Power power = pig.getPowerWithEnergy();
		if (power.isAfar()) {
			power.setPosition(pig.getPosition());
			
			//TODO Start animation
			//TODO Get enemy if power touched it
			//actionPigAttaksEnemy(enemy, power);
			
			return true;
		}
		
		return false;
	}
	
	private void actionPigAttaksEnemy(Enemy enemy, Power power) {
		power.act(enemy);
		
		if (enemy.isDied()) {
			removeElement(enemy);
			cumuleStatistics(enemy);
		}
	}
	
	public void removeElement(Element element) {
		this.round.getListElements().remove(element);
	}
	
	public void cumuleStatistics(Element element) {
		RoundCumulatedStatistics roundCumulatedStatistics = this.round.getRoundCumulatedStatistics();
		
		int scoreValue = 0;
		
		if (element instanceof Food) {
			Food food = (Food) element;
			scoreValue = food.getScorePoint();
			
			if (food.getName().equals(Cake.NAME)) {
				this.round.setCountEatenCakes(this.round.getCountEatenCakes() + 1);
				roundCumulatedStatistics.setTotalEatenCakes(roundCumulatedStatistics.getTotalEatenCakes() + 1);
			} else if (food.getName().equals(PoisonCake.NAME)) {
				this.round.setCountEatenPoisonCakes(this.round.getCountEatenPoisonCakes() + 1);
				roundCumulatedStatistics.setTotalEatenPoisonCakes(roundCumulatedStatistics.getTotalEatenPoisonCakes() + 1);
			}
		} else if (element instanceof Enemy) {
			Enemy enemy = (Enemy) element;
			scoreValue = enemy.getScorePoint();
			
			if (enemy.getName().equals(Nutritionist.NAME)) {
				this.round.setCountNutritionistKilled(this.round.getCountNutritionistKilled() + 1);
				roundCumulatedStatistics.setTotalNutritionistKilled(roundCumulatedStatistics.getTotalNutritionistKilled() + 1);
			} else if (enemy.getName().equals(Virus.NAME)) {
				this.round.setCountVirusKilled(this.round.getCountVirusKilled() + 1);
				roundCumulatedStatistics.setTotalVirusKilled(roundCumulatedStatistics.getTotalVirusKilled() + 1);
			}
		}
		
		this.round.setScore(this.round.getScore() + scoreValue);
		roundCumulatedStatistics.setTotalScore(roundCumulatedStatistics.getTotalScore() + scoreValue);
	}
	
	public void startMoveAnimation(Element element) {
		Timer timer = new Timer(0, new MoveListener(this, element, this.round.getListElements()));
		
		timer.setDelay(500);
		timer.start();
	}
	
	private void startEnemyPursuePig(Enemy enemy) {		
		
	}
}