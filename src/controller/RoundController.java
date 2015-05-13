package controller;

import java.time.ZonedDateTime;

import javax.swing.JOptionPane;

import main.Test;
import view.round.RoundView;
import db.RoundDAO;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.power.Power;
import game.round.Result;
import game.round.Round;
import game.round.RoundCumulatedStatistics;
import game.round.State;
import game.setting.GamePad;
import game.util.ArenaUtil;

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
		saveRound();
		
		//Remplissage
		if (this.round.getUpdatedAt() == null) {
			Test.testArena(this.round.getListElements());
		}
	}
	
	public boolean isRoundStopped() {
		if (this.round.getState() == State.STOPPED) {
			return true;
		}
		
		return false;
	}
	
	private void checkRound() {
		boolean hasRoundError = false;
		
		if (this.round.getCountEatenCakes() > this.round.getMaxCountEatenCakes()) {
			hasRoundError = true;
			//Throw exception
		}
		
		Pig pig = this.round.getListElements().getPig();
		if (pig.isDied() && !round.isFinished()) {
			hasRoundError = true;
			//Throw exception
		}
		
		if (hasRoundError) {
			exitRound();
		}
	}
	
	public void showRoundRulesMessage() {
		String title = "Round Rules";
		String message = "Eat cakes to succeed! Be careful from enemies and bad foods...";
		
		JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
	}
	
	public void displayRoundStart() {
		this.roundView.displayRoundStartView();
	}
	
	public void startRound() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
		
		this.roundView.requestFocusOnArenaView();
	}
	
	private void loadGamePad() {
		this.gamePad = SettingController.getInstance().loadGamePad();
	}
	
	public void restartRound() {
		this.round.deleteObservers();
		this.round = RoundDAO.load(this.round.getId());
		this.round.addObserver(this.roundView);
		this.roundView.update(this.round, null);
		
		startRound();
	}
	
	public void pauseRound() {
		this.round.setState(State.PAUSED);
		
		//TODO
		
		this.roundView.displayRoundMenuView();
	}
	
	public boolean showStopRoundMessage() {
		String title = "Exit round";
		String message = "Confirm ?";
		
		int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			stopRound();
			return true;
		}
		
		return false;
	}
	
	public void stopRound() {
		this.round.setState(State.STOPPED);
		
		if (!this.round.isFinished()) {
			showExitRoundSaveMessage();
		} else {
			Pig pig = this.round.getListElements().getPig();
			if (pig.isDied()) {
				this.round.setResult(Result.LOOSE);
			} else {
				this.round.setResult(Result.WIN);
			}
			
			saveRound();
			this.roundView.displayRoundResultView();
		}
	}
	
	public void showExitRoundSaveMessage() {
		String title = "Exit round";
		String message = "A round is in progress. Save ?";
		
		int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			saveRound();
		} else {
			removeRound();
		}
		
		exitRound();
	}
	
	public void saveRound() {
		this.round.setUpdatedAt(ZonedDateTime.now());
		GameController.getInstance().saveRound(this.round);
	}
	
	public void removeRound() {
		GameController.getInstance().removeRound(this.round);
	}
	
	public void exitRound() {
		this.round.deleteObservers();
		GameController.getInstance().setMenuRoundEnabled(false);
		GameController.getInstance().displayHome();
	}
	
	public void nextRound() {
		this.round.deleteObservers();
		GameController.getInstance().nextRound(this.round);
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
	
	private void actionMove(Element elementActor, Direction direction) {
		ListElements listElements = this.round.getListElements();
		
		boolean canMove = ArenaUtil.canMove(elementActor, direction, listElements);
		
		if (canMove) {
			elementActor.move(direction);
			
			updateArena();
			
			ListElements listElementsInTouch = ArenaUtil.getElementsInTouch(elementActor, this.round.getListElements());
			
			Element elementInTouch;
			for (int i=0; i<listElementsInTouch.size(); i++) {
				elementInTouch = listElementsInTouch.get(i);
				actionInTouch(elementActor, elementInTouch);
			}
		}
	}
	
	private void actionInTouch(Element elementActor, Element elementInTouch) {
		boolean canAct = ArenaUtil.canActInTouch(elementActor, elementInTouch);
		if (canAct) {
			if (elementActor.getName().equals(Pig.NAME)) {
				if (elementInTouch instanceof Enemy) {
					actionEnemyAttaksPig((Enemy) elementInTouch);
				} else if (elementInTouch instanceof Food) {
					actionPigEatsFood((Food) elementInTouch);
				}
			}
		}
	}
	
	private void actionEnemyAttaksPig(Enemy enemy) {
		Pig pig = this.round.getListElements().getPig();
		
		enemy.attakPig(pig);
		
		if (pig.isDied()) {
			this.round.setFinished(true);
			stopRound();
		}
	}
	
	private void actionPigEatsFood(Food food) {
		Pig pig = this.round.getListElements().getPig();
		
		if (pig.isGreedy()) {
			food.setEated(true);
			food.act(pig);
		}
		
		if (food.isEated()) {
			removeElement(food);
			cumuleStats(food);
			
			if (food.getName().equals(Cake.NAME)) {
				if (this.round.getCountEatenCakes() == this.round.getMaxCountEatenCakes()) {
					this.round.setFinished(true);
					stopRound();
				}
			}
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
			
			if (elementNextTo instanceof Enemy) {
				Power power = pig.getPowerWithEnergy();
				actionPigAttaksEnemy((Enemy) elementNextTo, power);
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
		Pig pig = this.round.getListElements().getPig();
		
		if (pig.isPowerful()) {
			power.act(enemy);
		}
		
		if (enemy.isDied()) {
			removeElement(enemy);
			cumuleStats(enemy);
		}
	}
	
	public void removeElement(Element element) {
		this.round.getListElements().remove(element);
	}
	
	public void cumuleStats(Element element) {
		RoundCumulatedStatistics roundCumulatedStatistics = this.round.getRoundCumulatedStatistics();
		
		int scoreValue = 0;
		
		if (element instanceof Food) {
			Food food = (Food) element;
			scoreValue = food.getScorePoint();
			
			if (food.getName().equals(Cake.NAME)) {
				this.round.setCountEatenCakes(this.round.getCountEatenCakes() + 1);
				roundCumulatedStatistics.setTotalCountEatenCakes(roundCumulatedStatistics.getTotalCountEatenCakes() + 1);
			}
		} else if (element instanceof Enemy) {
			Enemy enemy = (Enemy) element;
			scoreValue = enemy.getScorePoint();
			
			if (enemy.getName().equals(Nutritionist.NAME)) {
				this.round.setCountNutritionistKilled(this.round.getCountNutritionistKilled() + 1);
				roundCumulatedStatistics.setTotalCountNutritionistKilled(roundCumulatedStatistics.getTotalCountNutritionistKilled() + 1);
			} else if (enemy.getName().equals(Virus.NAME)) {
				this.round.setCountVirusKilled(this.round.getCountVirusKilled() + 1);
				roundCumulatedStatistics.setTotalCountVirusKilled(roundCumulatedStatistics.getTotalCountVirusKilled() + 1);
			}
		}
		
		this.round.setScore(this.round.getScore() + scoreValue);
		roundCumulatedStatistics.setTotalScore(roundCumulatedStatistics.getTotalScore() + scoreValue);
	}
}