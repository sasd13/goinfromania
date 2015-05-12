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
import game.element.character.Pig;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.power.Missile;
import game.element.power.Power;
import game.element.power.SuperMissile;
import game.round.Result;
import game.round.Round;
import game.round.State;
import game.setting.GamePad;
import game.util.ArenaUtil;
import game.util.EnemyAction;
import game.util.PigAction;
import game.util.RoundUtils;

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
		Test.testArena(this.round.getListElements());
	}
	
	public void startRound() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
		
		showStartRoundMessage();
	}
	
	public void restartRound() {
		this.round.deleteObservers();
		this.round = loadRound(this.round.getId());
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
			String title = "Exit round";
			String message = "Save your progress?";
			
			int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
			if (selected == JOptionPane.YES_OPTION) {
				this.round.setState(State.STOPPED);
				saveRound();
				GameController.getInstance().closeRound(this.round);
			} else if (selected == JOptionPane.NO_OPTION) {
				this.round.setState(State.STOPPED);
				GameController.getInstance().closeRound(this.round);
			}
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
	
	private void showStartRoundMessage() {
		if (this.round.getRoundNumber() == 1) {
			this.roundView.showMessage(true);
		} else {
			this.roundView.showMessage(false);
		}
	}
	
	public void nextRound() {
		GameController.getInstance().nextRound(this.round);
	}
	
	public void saveRound() {
		if (!this.round.isFinished()) {
			this.round.setUpdatedAt(ZonedDateTime.now());
			RoundDAO.save(this.round);
		}
	}
	
	private Round loadRound(String roundId) {
		Round round = RoundDAO.load(roundId);
		
		return round;
	}
	
	public void updateArena() {
		this.roundView.getArenaView().repaint();
	}
	
	private void loadGamePad() {
		this.gamePad = SettingController.getInstance().loadGamePad();
	}
	
	public void actionGamePad(int keyCode) {
		if (keyCode == this.gamePad.getKeyStart()) {
			if (this.round.getState() == State.STARTED) {
				pauseRound();
			} else if (this.round.getState() == State.PAUSED) {
				resumeRound();
			}else {
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
			} else {
				//TODO Throw exception
			}
		}
	}
	
	private void actionMove(Element elementActor, Direction direction) {
		ListElements listElements = this.round.getListElements();
		
		boolean canMove = ArenaUtil.canMove(elementActor, direction, listElements);
		
		if (canMove) {
			elementActor.move(direction);
			
			updateArena();
			checkElementsInTouch(elementActor);
		}
	}
	
	public void checkElementsInTouch(Element elementActor) {
		ListElements listElementsInTouch = ArenaUtil.getElementsInTouch(elementActor, this.round.getListElements());
		
		Element elementToAct;
		for (int i=0; i<listElementsInTouch.size(); i++) {
			elementToAct = listElementsInTouch.get(i);
			actionInTouch(elementActor, elementToAct);
		}
	}
	
	private void actionInTouch(Element elementActor, Element elementToAct) {
		Pig pig = (Pig) elementActor;
		
		boolean canAct = ArenaUtil.canActInTouch(elementActor, elementToAct);
		if (canAct) {
			if (elementToAct instanceof Enemy) {
				Enemy enemy = (Enemy) elementToAct;
				
				actionEnemyAttaksPig(enemy, pig);
			} else if (elementActor instanceof Pig) {
				if (elementToAct instanceof Food) {
					Food food = (Food) elementToAct;
					
					actionPigEatsFood(pig, food);
				}
			}
		}
	}
	
	private void actionEnemyAttaksPig(Enemy enemy, Pig pig) {
		EnemyAction enemyAction = new EnemyAction();
		enemyAction.enemyAttaksPig(enemy, pig);
		
		boolean isOver = RoundUtils.isRoundOver(round);
		if (isOver) {
			stopRound();
		}
	}
	
	private void actionPigEatsFood(Pig pig, Food food) {
		PigAction.pigEatsFood(pig, food);
		RoundUtils.removeElementAndCumulScore(round, food);
		
		if (food.getName().equals(Cake.NAME)) {
			this.round.setCountEatenCakes(this.round.getCountEatenCakes() + 1);
		}
		
		boolean isWon = RoundUtils.isRoundWon(round);
		if (isWon) {
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
		ListElements listElements = round.getListElements();
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
				Power power = pig.getPowerWithEnergy();
				
				actionPigAttaksEnemy(pig, enemy, power);
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
	
	private void actionPigAttaksEnemy(Pig pig, Enemy enemy, Power power) {
		PigAction.pigAttaksEnemy(pig, enemy, power);
		RoundUtils.removeElementAndCumulScore(round, enemy);
	}
}