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
import game.element.power.Missile;
import game.element.power.Power;
import game.element.power.SuperMissile;
import game.round.Result;
import game.round.Round;
import game.round.RoundStats;
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
		
		//Remplissage
		if (this.round.getUpdatedAt() == null) {
			Test.testArena(this.round.getListElements());
		}
	}
	
	public void showStartRoundMessage() {
		if (this.round.getRoundNumber() == 1) {
			this.roundView.showStartRoundMessageWithRules(true);
		} else {
			this.roundView.showStartRoundMessageWithRules(false);
		}
	}
	
	public void startRound() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
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
	
	public void resumeRound() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
		
		//TODO
	}
	
	public void pauseRound() {
		this.round.setState(State.PAUSED);
		
		//TODO
		
		this.roundView.displayRoundMenuView();
	}
	
	public void stopRound() {
		if (!this.round.isFinished()) {
			showExitRoundMessage();
		} else {
			this.round.setState(State.STOPPED);
			
			Pig pig = this.round.getListElements().getPig();
			if (pig.isDied()) {
				this.round.setResult(Result.LOOSE);
			} else {
				this.round.setResult(Result.WIN);
			}
			
			this.roundView.displayRoundResultView();
		}
	}
	
	public void showExitRoundMessage() {
		String title = "Exit round";
		String message = "Save your progress?";
		
		int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
		if (selected == JOptionPane.YES_OPTION) {
			this.round.setState(State.STOPPED);
			saveRound();
			GameController.getInstance().exitRound();
		} else if (selected == JOptionPane.NO_OPTION) {
			this.round.setState(State.STOPPED);
			GameController.getInstance().exitRound();
		}
	}
	
	public void nextRound() {
		GameController.getInstance().nextRound(this.round);
	}
	
	public void saveRound() {
		this.round.setUpdatedAt(ZonedDateTime.now());
		RoundDAO.save(this.round);
	}
	
	public void updateArena() {
		this.roundView.getArenaView().repaint();
	}
	
	public void actionGamePad(int keyCode) {
		if (keyCode == this.gamePad.getKeyStart()) {
			if (this.round.getState() == State.STARTED) {
				pauseRound();
			} else if (this.round.getState() == State.PAUSED) {
				resumeRound();
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
			
			Element elementToAct;
			for (int i=0; i<listElementsInTouch.size(); i++) {
				elementToAct = listElementsInTouch.get(i);
				actionInTouch(elementActor, elementToAct);
			}
		}
	}
	
	private void actionInTouch(Element elementActor, Element elementToAct) {
		boolean canAct = ArenaUtil.canActInTouch(elementActor, elementToAct);
		if (canAct) {
			if (elementToAct instanceof Enemy) {
				Enemy enemy = (Enemy) elementToAct;
				actionEnemyAttaksPig(enemy);
			} else if (elementActor instanceof Pig) {
				if (elementToAct instanceof Food) {
					Food food = (Food) elementToAct;
					actionPigEatsFood(food);
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
		
		pig.eatFood(food);
		
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
		ListElements listElements = this.round.getListElements();
		Pig pig = listElements.getPig();
		
		ListElements listElementsNextTo = ArenaUtil.getElementsNextTo(pig, listElements);
		
		if (listElementsNextTo.isEmpty()) {
			return false;
		}
		
		Element elementNextTo;
		for (int i=0; i<listElementsNextTo.size(); i++) {
			elementNextTo = listElementsNextTo.get(i);
			
			if (elementNextTo instanceof Enemy) {
				Enemy enemy = (Enemy) elementNextTo;
				actionPigAttaksEnemy(enemy);
			}
		}
		
		return true;
	}
	
	private void actionPigAttaksAfar() {
		Pig pig = round.getListElements().getPig();
		
		Power power = pig.getPowerWithEnergy();
		
		if (power instanceof Missile || power instanceof SuperMissile) {
			power.setPosition(pig.getPosition());
			
			//TODO Start animation
			//TODO Get enemy if power touched it
			//actionPigAttaksEnemy(pig, enemy, power);
		}
	}
	
	private void actionPigAttaksEnemy(Enemy enemy) {
		Pig pig = this.round.getListElements().getPig();
		
		pig.attakEnemy(enemy);
		
		if (enemy.isDied()) {
			removeElement(enemy);
			cumuleStats(enemy);
		}
	}
	
	public void removeElement(Element element) {
		this.round.getListElements().remove(element);
	}
	
	public void cumuleStats(Element element) {
		RoundStats roundStats = this.round.getRoundStats();
		
		int scoreValue = 0;
		
		if (element instanceof Food) {
			Food food = (Food) element;
			scoreValue = food.getScorePoint();
			
			if (food.getName().equals(Cake.NAME)) {
				this.round.setCountEatenCakes(this.round.getCountEatenCakes() + 1);
				roundStats.setTotalCountEatenCakes(roundStats.getTotalCountEatenCakes() + 1);
			}
		} else if (element instanceof Enemy) {
			Enemy enemy = (Enemy) element;
			scoreValue = enemy.getScorePoint();
			
			if (enemy.getName().equals(Nutritionist.NAME)) {
				this.round.setCountNutritionistKilled(this.round.getCountNutritionistKilled() + 1);
				roundStats.setTotalCountNutritionistKilled(roundStats.getTotalCountNutritionistKilled() + 1);
			} else if (enemy.getName().equals(Virus.NAME)) {
				this.round.setCountVirusKilled(this.round.getCountVirusKilled() + 1);
				roundStats.setTotalCountVirusKilled(roundStats.getTotalCountVirusKilled() + 1);
			}
		}
		
		this.round.setScore(this.round.getScore() + scoreValue);
		roundStats.setTotalScore(roundStats.getTotalScore() + scoreValue);
	}
}