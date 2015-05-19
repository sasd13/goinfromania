package controller;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.food.Food;
import game.element.power.Power;
import util.ArenaUtil;
import util.timer.AppearanceScheduler;
import util.timer.MoveScheduler;
import view.round.ArenaView;

public class ArenaController {

	private static ArenaView arenaView;
	private static ListElements listElements;
	
	private static AppearanceScheduler appearanceScheduler;
	private static MoveScheduler moveScheduler;
	
	public static void initialize(ArenaView myArenaView, ListElements myListElements) {
		arenaView = myArenaView;
		listElements = myListElements;
		
		appearanceScheduler = new AppearanceScheduler(listElements);
		moveScheduler = new MoveScheduler(listElements);
	}
	
	public static void start() {		
		arenaView.requestFocusInWindow();
		
		appearanceScheduler.start();
		moveScheduler.start();
	}
	
	public static void stop() {
		appearanceScheduler.stop();
		moveScheduler.stop();
	}
	
	public static void repaintArena() {
		arenaView.repaint();
	}
	
	public static void actionMove(Element elementActor, Direction direction) {
		boolean canMove = ArenaUtil.canMove(elementActor, direction, listElements);
		if (canMove) {
			elementActor.move(direction);
			repaintArena();
			
			ListElements listElementsInTouch = ArenaUtil.getElementsInTouch(elementActor, listElements);
			
			for (int i=0; i<listElementsInTouch.size(); i++) {
				actionInTouch(elementActor, listElementsInTouch.get(i));
			}
		}
	}
	
	private static void actionInTouch(Element elementActor, Element elementInTouch) {
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
	
	private static void actionEnemyAttaksPig(Enemy enemy, Power power) {		
		Pig pig = listElements.getPig();
		
		power.act(pig);
		enemy.setPowerlessForDelay();
		
		RoundController.checkPigLife();
	}
	
	private static void actionPigEatsFood(Food food) {
		Pig pig = listElements.getPig();
		
		food.setEated(true);
		food.act(pig);
		
		listElements.remove(food);
		RoundController.cumuleFoodStatistics(food);
		RoundController.checkEatenCakes();
	}
	
	public static void initPigAttak() {
		boolean hasAttakedNextTo = actionPigAttaksNextTo();
		if (!hasAttakedNextTo) {
			actionPigAttaksAfar();
		}
	}
	
	private static boolean actionPigAttaksNextTo() {
		Pig pig = listElements.getPig();
		
		ListElements listElementsNextTo = ArenaUtil.getElementsNextTo(pig, listElements);
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
	
	private static boolean actionPigAttaksAfar() {
		Pig pig = listElements.getPig();
		
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
	
	private static void actionPigAttaksEnemy(Enemy enemy, Power power) {
		power.act(enemy);
		
		if (enemy.isDied()) {
			listElements.remove(enemy);
			RoundController.cumuleEnemyStatistics(enemy);
		}
	}
}
