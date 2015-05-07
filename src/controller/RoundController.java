package controller;

import java.awt.Point;

import javax.swing.JOptionPane;

import util.MathUtil;
import view.ArenaView;
import view.PigStateView;
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
import game.round.arena.Arena;
import game.round.arena.GamePadListener;
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
		
		PigStateView pigStateView = this.roundView.getPigStateView();
		Pig pig = this.round.getPig();
		pig.addObserver(pigStateView);
		pigStateView.update(pig, null);
		
		Arena arena = this.round.getArena();
		ArenaView arenaView = this.roundView.getArenaView();
		arena.addObserver(arenaView);
		arenaView.update(arena, null);
		
		arenaView.addKeyListener(new GamePadListener());
		arenaView.setFocusable(true);
		arenaView.requestFocusInWindow();
	}
	
	public void start() {
		this.round.setState(State.STARTED);
		
		loadGamePad();
		
		Arena arena = this.round.getArena();
		arena.addElement(this.round.getPig());
		
		ArenaView arenaView = this.roundView.getArenaView();
		arenaView.addKeyListener(new GamePadListener());
		arenaView.setFocusable(true);
		arenaView.requestFocusInWindow();
		
		testArena();
	}
	
	private void testArena() {
		Arena arena = this.round.getArena();
		
		ListElements listElements = arena.getListElements();
		
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
			
			Pig pig = this.round.getPig();
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
			this.roundView.getArenaView().repaint();
			checkElementAtPigPosition();
		}
	}
	
	private void initMove(Direction direction) {
		Pig pig = this.round.getPig();
		
		boolean canMove = canMove(direction);
		if (canMove) {
			pig.move(direction);
		}
		
		this.roundView.getArenaView().repaint();
		checkElementAtPigPosition();
	}
	
	public void actionPigAttakEnemy(Enemy enemy) {
		Pig pig = this.round.getPig();
		
		if (pig.isPowerful()) {
			Power power = pig.getPowerWithEnergy();
			power.setPosition(pig.getPosition());
			power.act(enemy);
			
			if (enemy.isDied()) {
				this.round.getArena().getListElements().remove(enemy);
				cumulScore(enemy.getScorePoint());
			}
		}
	}
	
	public void actionEnemyAttakPig(Enemy enemy) {
		Pig pig = this.round.getPig();
		
		Power power = enemy.getPower();
		power.act(pig);
		
		checkPigLife();
	}
	
	public void actionPigEatFood(Food food) {
		Pig pig = this.round.getPig();
		
		if (pig.isGreedy()) {
			food.setEated(true);
			food.act(pig);
			
			this.round.getArena().getListElements().remove(food);
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
		int countEatenCake = pig.getCountEatenCakes();
		
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
		
		Point position = pig.getPosition();
		
		Element element = getElementAtPosition(position);
		
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
	
	public boolean canMove(Direction direction) {
		ListElements listElements = getDetectedElementsAtNextPigGravityPosition(direction);
		
		for (int i=0; i<listElements.size(); i++) {
			if (listElements.get(i) instanceof Wall) {
				return false;
			}
		}
		
		return true;
	}
	
	private ListElements getDetectedElementsAtNextPigGravityPosition(Direction direction) {
		ListElements listDetectedElement = new ListElements();
		
		Pig pig = this.round.getPig();
		Point nextPigPosition = pig.getNextPosition(direction);
		Point nextPigGravityPosition = MathUtil.getGravityPosition(nextPigPosition, pig.getDimension());
		ListElements listElements = this.round.getArena().getListElements();
		
		Element element;
		for (int i=0; i<listElements.size(); i++) {
			element = listElements.get(i);
			
			if (!(element instanceof Pig)) {
				Point elementGravityPosition = MathUtil.getGravityPosition(element.getPosition(), element.getDimension());
				
				boolean detected = detectInsideCollision(nextPigGravityPosition, elementGravityPosition);
				if (detected) {
					listDetectedElement.add(element);
				}
			}
		}
		
		return listDetectedElement;
	}
	
	public Element getElementAtPosition(Point position) {
		ListElements listElements = this.round.getArena().getListElements();
		
		Element element;
		for (int i=0; i<listElements.size(); i++) {
			element = listElements.get(i);
			if (element.getPosition().equals(position) && !(element instanceof Pig)) {
				return element;
			}
		}
		
		return null;
	}
	
	private boolean detectInsideCollision(Point gravityPosition1, Point gravityPosition2) {
		if (MathUtil.distance(gravityPosition1, gravityPosition2) < 100) {
			return true;
		}
		
		return false;
	}
	
	private boolean detectOutsideCollision(Point gravityPosition1, Point gravityPosition2) {
		if (MathUtil.distance(gravityPosition1, gravityPosition2) < Math.sqrt(2*Math.pow(100, 2))) {
			return true;
		}
		
		return false;
	}
}