package controller;

import java.awt.Dimension;
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
			initMove(Direction.LEFT);
		} else if (keyCode == this.gamePad.getKeyMoveRight()) {
			initMove(Direction.RIGHT);
		} else if (keyCode == this.gamePad.getKeyMoveUp()) {
			initMove(Direction.UP);
		} else if (keyCode == this.gamePad.getKeyMoveDown()) {
			initMove(Direction.DOWN);
		} else if (keyCode == this.gamePad.getKeyPigAttak()) {
			//TODO
			this.roundView.repaintArenaView();
			checkElementAtPigPosition();
		}
	}
	
	private void initMove(Direction direction) {
		boolean canMove = canMove(direction);
		
		if (canMove) {
			Pig pig = this.round.getListElements().getPig();
			pig.move(direction);
			
			this.roundView.repaintArenaView();
			checkElementAtPigPosition();
		}
	}
	
	private boolean canMove(Direction direction) {
		ListElements listDetectedElements = ArenaUtil.getDetectedElementsAtNextPigPosition(this.round.getListElements(), direction);
		
		for (int i=0; i<listDetectedElements.size(); i++) {
			if (listDetectedElements.get(i) instanceof Wall) {
				return false;
			}
		}
		
		return true;
	}
	
	public void checkElementAtPigPosition() {
		ListElements listDetectedElements = ArenaUtil.getDetectedElementsAtPigPosition(this.round.getListElements());
		
		Element element;
		for (int i=0; i<listDetectedElements.size(); i++) {
			element = listDetectedElements.get(i);
			
			initAction(element);
		}
	}
	
	public void initAction(Element element) {
		boolean canAct = canAct(element);
		
		if (canAct) {
			if (element instanceof Food) {
				Food food = (Food) element;
				actionPigEatFood(food);
			} else if (element instanceof Enemy) {
				Enemy enemy = (Enemy) element;
				//actionEnemyAttakPig(enemy);
			}
		}
	}
	
	private boolean canAct(Element element) {
		Pig pig = this.round.getListElements().getPig();
		
		Point position1 = pig.getPosition();
		Dimension dimension1 = pig.getDimension();
		
		Point position2 = element.getPosition();
		Dimension dimension2 = element.getDimension();
		
		double proportion = ArenaUtil.getProportionCollision(position1, dimension1, position2, dimension2);
		
		if (proportion > 50) {
			return true;
		}
		
		return false;
	}
	
	public void actionPigAttakEnemy(Enemy enemy) {
		Pig pig = this.round.getListElements().getPig();
		
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
	
	public void actionEnemyAttakPig(Enemy enemy) {
		Pig pig = this.round.getListElements().getPig();
		
		Power power = enemy.getPower();
		power.act(pig);
		
		checkPigLife();
	}
	
	public void actionPigEatFood(Food food) {
		Pig pig = this.round.getListElements().getPig();
		
		if (pig.isGreedy()) {
			food.setEated(true);
			food.act(pig);
			
			this.round.getListElements().remove(food);
			cumulScore(food.getScorePoint());
		}
		
		checkEatenCake();
	}
	
	private void cumulScore(int scoreValue) {
		this.round.setScore(this.round.getScore() + scoreValue);
	}
	
	public void checkPigLife() {
		Pig pig = this.round.getListElements().getPig();
		
		if (pig.isDied()) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	public void checkEatenCake() {
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
}