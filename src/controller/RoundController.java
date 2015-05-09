package controller;

import java.awt.Point;

import javax.swing.JOptionPane;

import util.ArenaUtil;
import util.EnemyActions;
import util.PigActions;
import util.RoundUtils;
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
import game.element.power.Missile;
import game.element.power.Power;
import game.element.power.SuperMissile;
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
		
		PoisonCake poisonCake = new PoisonCake();
		poisonCake.setPosition(new Point(200, 200));
		listElements.add(poisonCake);
		
		Wall wall1 = new Wall();
		wall1.setPosition(new Point(300, 100));
		listElements.add(wall1);
		
		Wall wall2 = new Wall();
		wall2.setPosition(new Point(300, 200));
		listElements.add(wall2);
		
		Nutritionist nutritionist = new Nutritionist();
		nutritionist.setPosition(new Point(300, 300));
		listElements.add(nutritionist);
		
		Virus virus = new Virus();
		virus.setPosition(new Point(300, 400));
		listElements.add(virus);
		
		Cake cake1 = new Cake();
		cake1.setPosition(new Point(100, 0));
		listElements.add(cake1);
		
		Cake cake2 = new Cake();
		cake2.setPosition(new Point(500, 0));
		listElements.add(cake2);
		
		Cake cake3 = new Cake();
		cake3.setPosition(new Point(500, 200));
		listElements.add(cake3);
		
		Cake cake4 = new Cake();
		cake4.setPosition(new Point(500, 400));
		listElements.add(cake4);
		
		Cake cake5 = new Cake();
		cake5.setPosition(new Point(700, 0));
		listElements.add(cake5);
		
		Cake cake6 = new Cake();
		cake6.setPosition(new Point(700, 200));
		listElements.add(cake6);
		
		Cake cake7 = new Cake();
		cake7.setPosition(new Point(700, 400));
		listElements.add(cake7);
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
			
			this.roundView.repaintArenaView();
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
		boolean canAct = ArenaUtil.canActInTouch(elementActor, elementToAct);
		
		if (canAct) {
			if (elementActor instanceof Enemy) {
				Enemy enemy = (Enemy) elementActor;
				
				Pig pig = (Pig) elementToAct;
				actionEnemyAttaksPig(enemy, pig);
			} else if (elementActor instanceof Pig) {
				Pig pig = (Pig) elementActor;
				
				if (elementToAct instanceof Food) {
					Food food = (Food) elementToAct;
					actionPigEatsFood(pig, food);
				}
			}
		}
	}
	
	private void actionEnemyAttaksPig(Enemy enemy, Pig pig) {
		boolean canAct = ArenaUtil.canActInTouch(enemy, pig);
		
		if (canAct) {
			EnemyActions.enemyAttaksPig(enemy, pig);
			
			boolean isOver = RoundUtils.isRoundOver(this.round);
			if (isOver) {
				stop();
			}
		}
	}
	
	private void actionPigEatsFood(Pig pig, Food food) {
		boolean canAct = ArenaUtil.canActInTouch(pig, food);
		
		if (canAct) {
			PigActions.pigEatsFood(pig, food);
			RoundUtils.removeElementAndCumulScore(this.round, food);
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
				Power power = pig.getPowerWithEnergy();
				
				actionPigAttaksEnemy(pig, enemy, power);
			}
		}
		
		return true;
	}
	
	private void actionPigAttaksAfar() {
		Pig pig = this.round.getListElements().getPig();
		
		Power power = pig.getPowerWithEnergy();
		
		if (power instanceof Missile || power instanceof SuperMissile) {
			power.setPosition(pig.getPosition());
			
			//TODO Start animation
			//TODO Get enemy if power touched it
			//actionPigAttaksEnemy(pig, enemy, power);
		}
	}
	
	private void actionPigAttaksEnemy(Pig pig, Enemy enemy, Power power) {
		PigActions.pigAttaksEnemy(pig, enemy, power);
		RoundUtils.removeElementAndCumulScore(this.round, enemy);
	}
}