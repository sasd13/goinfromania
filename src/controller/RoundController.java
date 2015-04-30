package controller;

import java.awt.Point;

import javax.swing.JOptionPane;

import view.ArenaView;
import view.PigStateView;
import view.RoundView;
import db.RoundDAO;
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
import game.round.GamePadListener;
import game.round.Level;
import game.round.Result;
import game.round.Round;
import game.round.State;
import game.setting.Direction;
import game.setting.GamePad;

public class RoundController {

	private Round round;
	private RoundView roundView;
	
	private GamePad gamePad;
	private ArenaView arenaView;
	
	public RoundController(Round round, RoundView roundView) {
		this.round = round;
		this.roundView = roundView;
		
		this.round.addObserver(this.roundView);
		this.roundView.update(this.round, null);
		
		this.arenaView = this.roundView.getArenaView();
		ListElements listElements = this.round.getListElement();
		listElements.addObserver(this.arenaView);
		this.arenaView.update(listElements, null);
		
		PigStateView pigStateView = this.roundView.getPigStateView();
		Pig pig = this.round.getPig();
		pig.addObserver(pigStateView);
		pigStateView.update(pig, null);
	}
	
	public void start() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
		
		GamePadListener gamePadListener = new GamePadListener();
		this.arenaView.addKeyListener(gamePadListener);
		this.arenaView.setFocusable(true);
		this.arenaView.requestFocusInWindow();
		
		testArena();
	}
	
	private void testArena() {
		ListElements listElements = this.round.getListElement();
		
		Cake cake = new Cake();
		cake.setPosition(new Point(300, 100));
		listElements.add(cake);
		
		Nutritionist nutritionist = new Nutritionist();
		nutritionist.setPosition(new Point(500, 100));
		listElements.add(nutritionist);
		
		PoisonCake poisonCake = new PoisonCake();
		poisonCake.setPosition(new Point(300, 300));
		listElements.add(poisonCake);
		
		Virus virus = new Virus();
		virus.setPosition(new Point(500, 300));
		listElements.add(virus);
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
			
			if (this.round.getPig().isDied()) {
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
		} else {
			if (keyCode == this.gamePad.getKeyMoveLeft()) {
				this.round.getPig().move(Direction.LEFT);
			} else if (keyCode == this.gamePad.getKeyMoveRight()) {
				this.round.getPig().move(Direction.RIGHT);
			} else if (keyCode == this.gamePad.getKeyMoveUp()) {
				this.round.getPig().move(Direction.UP);
			} else if (keyCode == this.gamePad.getKeyMoveDown()) {
				this.round.getPig().move(Direction.DOWN);
			} else if (keyCode == this.gamePad.getKeyPigAttak()) {
				//TODO
			}
			
			this.arenaView.repaint();
			
			checkElementAtPigPosition();
		}
	}
	
	public void actionPigAttakEnemy(Enemy enemy) {
		Pig pig = this.round.getPig();
		
		if (pig.isPowerful()) {
			Power power = pig.getPowerWithEnergy();
			power.setPosition(pig.getPosition());
			power.act(enemy);
			
			if (enemy.isDied()) {
				this.round.getListElement().remove(enemy);
				cumulScore(enemy.getScorePoint());
			}
		}
	}
	
	public void actionEnemyAttakPig(Enemy enemy) {
		Pig pig = (Pig) this.round.getPig();
		
		Power power = enemy.getPower();
		power.act(pig);
		
		checkPigLife();
	}
	
	public void actionPigEatFood(Food food) {
		Pig pig = this.round.getPig();
		
		if (pig.isGreedy()) {
			food.setEated(true);
			food.act(pig);
			
			this.round.getListElement().remove(food);
			cumulScore(food.getScorePoint());
		}
		
		checkEatenCake();
	}
	
	private void cumulScore(int scoreValue) {
		this.round.setScore(this.round.getScore() + scoreValue);
	}
	
	public void checkPigLife() {
		Pig pig = this.round.getPig();
		
		if (pig.isDied()) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	public void checkEatenCake() {
		Level level = this.round.getLevel();
		
		Pig pig = this.round.getPig();
		int countEatenCake = pig.getCountEatenCake();
		
		if ((level == Level.EASY && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_EASY)
				|| (level == Level.NORMAL && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_NORMAL)
				|| (level == Level.HARD && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_HARD)) {
			this.round.setFinished(true);
			stop();
		}
	}
	
	//Fonctionne a la position exacte du Pig
	public void checkElementAtPigPosition() {
		Pig pig = this.round.getPig();
		
		Element element = this.round.getListElement().getElementAtPosition(pig.getPosition());
		
		if (element != null) {
			if (element instanceof Food) {
				Food food = (Food) element;
				actionPigEatFood(food);
			} else if (element instanceof Enemy) {
				Enemy enemy = (Enemy) element;
				actionEnemyAttakPig(enemy);
			}
		}
	}
	
	//Doit fonctionner pour les positions aux alentours du Pig
	public void checkElementAtExtendedPigPosition() {
		//TODO
	}
	
	public void checkElementAtNextPigPosition() {
		Pig pig = this.round.getPig();
		
		Element element = this.round.getListElement().getElementAtPosition(pig.getPosition());
		
		if (element != null) {
			if (element instanceof Food) {
				Food food = (Food) element;
				actionPigEatFood(food);
			}
		}
	}
}
