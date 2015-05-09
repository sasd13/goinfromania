package controller;

import java.awt.Point;

import javax.swing.JOptionPane;

import util.ArenaUtil;
import view.RoundView;
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
import game.element.food.PoisonCake;
import game.element.item.Wall;
import game.element.power.Power;
import game.round.Level;
import game.round.Result;
import game.round.Round;
import game.round.State;
import game.setting.GamePad;

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
	}
	
	public void start() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
		
		testArena();
		
		this.roundView.focusArenaView();
	}
	
	private void testArena() {
		ListElements listElements = this.round.getListElements();
		
		Cake cake = new Cake();
		cake.setPosition(new Point(300, 0));
		listElements.add(cake);
		
		Nutritionist nutritionist = new Nutritionist();
		nutritionist.setPosition(new Point(500, 100));
		listElements.add(nutritionist);
		
		PoisonCake poisonCake = new PoisonCake();
		poisonCake.setPosition(new Point(300, 400));
		listElements.add(poisonCake);
		
		Virus virus = new Virus();
		virus.setPosition(new Point(500, 300));
		listElements.add(virus);
		
		Wall wall1 = new Wall();
		wall1.setPosition(new Point(300, 100));
		listElements.add(wall1);
		
		Wall wall2 = new Wall();
		wall2.setPosition(new Point(300, 200));
		listElements.add(wall2);
		
		Wall wall3 = new Wall();
		wall3.setPosition(new Point(300, 300));
		listElements.add(wall3);
	}
	
	public void restart() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
	}
	
	public void resume() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
	}
	
	public void pause() {
		this.round.setState(State.PAUSED);
		
		String title = "Round";
		String message = "Paused... Click \"OK\" to resume";
		
		JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
	}
	
	public void stop() {
		this.round.setState(State.STOPPED);
		
		String title = null;
		String message = null;
		
		if (!this.round.isFinished()) {
			title = "Exit round";
			message = "Save your progress?";
			
			int selected = JOptionPane.showConfirmDialog(this.roundView, message, title, JOptionPane.YES_NO_OPTION);
			if (selected == JOptionPane.YES_OPTION) {
				save();
			}
		} else {
			title = "Result";
			
			Pig pig = this.round.getListElements().getPig();
			if (pig.isDied()) {
				this.round.setResult(Result.LOOSE);
				message = "YOU LOOSE... :-(";
			} else {
				this.round.setResult(Result.WIN);
				message = "YOU WIN :-)!!! Score : " + this.round.getScore();
			}
			
			JOptionPane.showMessageDialog(this.roundView, message, title, JOptionPane.OK_OPTION);
		}
		
		GameController.getInstance().closeRound(this.round);
	}
	
	public void save() {
		if (!this.round.isFinished()) {
			RoundDAO.save(this.round);
		}
	}
	
	private void loadGamePad() {
		this.gamePad = SettingController.getInstance().loadGamePad();
	}
	
	public void checkPigLife() {
		Pig pig = this.round.getListElements().getPig();
		
		if (pig.isDied()) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	public void checkEatenCakes() {
		Level level = this.round.getLevel();
		
		Pig pig = this.round.getListElements().getPig();
		int countEatenCake = pig.getCountEatenCakes();
		
		if ((level == Level.EASY && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_EASY)
				|| (level == Level.NORMAL && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_NORMAL)
				|| (level == Level.HARD && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_HARD)) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	private void cumulScore(int scoreValue) {
		this.round.setScore(this.round.getScore() + scoreValue);
	}
	
	public void actionGamePad(int keyCode) {
		if (keyCode == this.gamePad.getKeyStart()) {
			if (this.round.getState() == State.STARTED) {
				pause();
			} else if (this.round.getState() == State.PAUSED) {
				resume();
			} else {
				//TODO Throw exception
			}
		} else if (keyCode == this.gamePad.getKeyMoveLeft()) {
			initPigMove(Direction.LEFT);
		} else if (keyCode == this.gamePad.getKeyMoveRight()) {
			initPigMove(Direction.RIGHT);
		} else if (keyCode == this.gamePad.getKeyMoveUp()) {
			initPigMove(Direction.UP);
		} else if (keyCode == this.gamePad.getKeyMoveDown()) {
			initPigMove(Direction.DOWN);
		} else if (keyCode == this.gamePad.getKeyPigAttak()) {
			//TODO
			this.roundView.repaintArenaView();
		}
	}
	
	private void initPigMove(Direction direction) {
		ListElements listElements = this.round.getListElements();
		Pig pig = listElements.getPig();
		
		boolean pigCanMove = ArenaUtil.canMove(pig, direction, listElements);
		
		if (pigCanMove) {
			pig.move(direction);
			
			this.roundView.repaintArenaView();
			checkElementsInTouchWithPig();
		}
	}
	
	public void checkElementsInTouchWithPig() {
		ListElements listElementsInTouch = ArenaUtil.getElementsInTouchWithPig(this.round.getListElements());
		
		Element element;
		for (int i=0; i<listElementsInTouch.size(); i++) {
			element = listElementsInTouch.get(i);
			initPigActionInTouch(element);
		}
	}
	
	public void initPigActionInTouch(Element element) {
		Pig pig = this.round.getListElements().getPig();
		
		boolean canAct = ArenaUtil.canActInTouch(pig, element);
		
		if (canAct) {
			if (element instanceof Food) {
				Food food = (Food) element;
				actionPigEatsFood(pig, food);
			}
		}
	}
	
	public void pigAttak() {
		boolean hasAttakNextTo = initPigAttakNextTo();
		
		if (!hasAttakNextTo) {
			initPigAttakAfar();
		}
	}
	
	public boolean initPigAttakNextTo() {
		ListElements listElements = this.round.getListElements();
		Pig pig = listElements.getPig();
		
		ListElements listElementsNextTo = ArenaUtil.getElementsNextToPig(listElements);
		
		Element element;
		for (int i=0; i<listElementsNextTo.size(); i++) {
			element = listElementsNextTo.get(i);
			
			if (element instanceof Enemy) {
				Enemy enemy = (Enemy) element;
				actionPigAttaksEnemyNext(pig, enemy);
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean initPigAttakAfar() {
		Pig pig = this.round.getListElements().getPig();
		
		//TODO
		
		return false;
	}
	
	public void actionPigEatsFood(Pig pig, Food food) {
		if (pig.isGreedy()) {
			food.setEated(true);
			food.act(pig);
			
			this.round.getListElements().remove(food);
			cumulScore(food.getScorePoint());
			checkEatenCakes();
		}
	}
	
	public void actionPigAttaksEnemyNext(Pig pig, Enemy enemy) {
		if (pig.isPowerful()) {
			Power power = pig.getPowerWithEnergy();
			power.setPosition(pig.getPosition());
			power.act(enemy);
			
			if (enemy.isDied()) {
				this.round.getListElements().remove(enemy);
				cumulScore(enemy.getScorePoint());
			}
		}
	}
	
	public void actionPigAttaksEnemyAfar(Pig pig) {
		if (pig.isPowerful()) {
			Power power = pig.getPowerWithEnergy();
			power.setPosition(pig.getPosition());
			
			//TODO
			
			/*if (enemy.isDied()) {
				this.round.getListElements().remove(enemy);
				cumulScore(enemy.getScorePoint());
			}*/
		}
	}
	
	public void initEnemyAction(Enemy enemy, Pig pig) {
		boolean canAct = ArenaUtil.canActInTouch(enemy, pig);
		
		if (canAct) {
			actionEnemyAttaksPig(enemy, pig);
		}
	}
	
	public void actionEnemyAttaksPig(Enemy enemy, Pig pig) {
		Power power = enemy.getPower();
		power.act(pig);
		
		checkPigLife();
	}
}