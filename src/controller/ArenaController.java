package controller;

import java.awt.Point;

import controller.anim.AutoAppearanceAnimation;
import controller.anim.EnemyAutoMoveAnimation;
import controller.anim.FoodAutoMoveAnimation;
import controller.anim.ImageAnimation;
import controller.anim.power.MissileAnimation;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.food.Food;
import game.element.power.Missile;
import game.element.power.Power;
import game.round.Level;
import game.round.Round;
import util.ArenaUtil;
import view.round.ArenaView;

public class ArenaController {

	private static ArenaView arenaView;
	private static ListElements listElements;
	
	private static AutoAppearanceAnimation autoAppearanceAnimation;
	private static FoodAutoMoveAnimation foodAutoMoveAnimation;
	private static EnemyAutoMoveAnimation enemyAutoMoveAnimation;
	
	public static void initialize(ArenaView myArenaView, Round round) {
		arenaView = myArenaView;
		listElements = round.getListElements();
		
		Level level = round.getLevel();
		autoAppearanceAnimation = new AutoAppearanceAnimation(level, listElements);
		foodAutoMoveAnimation = new FoodAutoMoveAnimation(level, listElements);
		enemyAutoMoveAnimation = new EnemyAutoMoveAnimation(level, listElements);
		
		//Decremente les "delay" tous les deux tours
		int decreaseValue = round.getRoundNumber()/2 - (round.getRoundNumber() - 1)%2;
		
		autoAppearanceAnimation.setDelay(autoAppearanceAnimation.getDelay() - decreaseValue);
		foodAutoMoveAnimation.setDelay(foodAutoMoveAnimation.getDelay() - decreaseValue);
		enemyAutoMoveAnimation.setDelay(enemyAutoMoveAnimation.getDelay() - decreaseValue);
	}
	
	public static void start() {
		arenaView.requestFocusInWindow();
		
		listElements.getPig().setMovable(true);
		
		autoAppearanceAnimation.start();
		foodAutoMoveAnimation.start();
		enemyAutoMoveAnimation.start();
	}
	
	public static void stop() {
		listElements.getPig().setMovable(false);
		
		autoAppearanceAnimation.stop();
		foodAutoMoveAnimation.stop();
		enemyAutoMoveAnimation.stop();
	}
	
	public static void repaintArena() {
		arenaView.repaint();
	}
	
	public static void addElement(Element element) {
		listElements.add(element);
		
		RoundController.checkListElementsSize();
	}
	
	public static void removeElement(Element element) {
		listElements.remove(element);
	}
	
	public static void actionMove(Element elementActor, Direction direction) {
		if (elementActor.isMovable()) {
			boolean canMove = ArenaUtil.canMoveInDirection(elementActor, direction, listElements);
			if (canMove) {
				moveElement(elementActor, direction);
				checkElementsInTouch(elementActor, listElements);
			}
		}
	}
	
	private static void moveElement(Element element, Direction direction) {
		Point nextPosition = element.getNextPosition(direction);
		element.setPosition(nextPosition);
		
		repaintArena();
	}
	
	private static void checkElementsInTouch(Element elementActor, ListElements listElements) {
		ListElements listElementsInTouch = ArenaUtil.getElementsInTouch(elementActor, listElements);
		
		for (int i=0; i<listElementsInTouch.size(); i++) {
			actionInTouch(elementActor, listElementsInTouch.get(i));
		}
	}
	
	public static void actionInTouch(Element elementActor, Element elementInTouch) {
		boolean canAct = ArenaUtil.canActInTouch(elementActor, elementInTouch);
		if (canAct) {
			if (elementActor instanceof Pig) {
				actionPigInTouch((Pig) elementActor, elementInTouch);
			} else if (elementActor instanceof Enemy) {
				actionEnemyInTouch((Enemy) elementActor, elementInTouch);
			}
		}
	}
	
	private static void actionPigInTouch(Pig pig, Element elementInTouch) {
		if (elementInTouch instanceof Enemy) {
			Enemy enemy = (Enemy) elementInTouch;
			
			if (enemy.isPowerful()) {
				EnemyController.actionEnemyAttaksPig(enemy.getPower(), enemy, pig);
			}
		} else if (elementInTouch instanceof Food) {
			Food food = (Food) elementInTouch;
			
			if (pig.isGreedy()) {
				FoodController.actionPigEatsFood(food, pig);
			}
		}
	}
	
	private static void actionEnemyInTouch(Enemy enemy, Element elementInTouch) {
		if (elementInTouch instanceof Pig) {
			Pig pig = (Pig) elementInTouch;
			
			if (enemy.isPowerful()) {
				EnemyController.actionEnemyAttaksPig(enemy.getPower(), enemy, pig);
			}
		}
	}
	
	public static void initPigAttak() {
		Pig pig = listElements.getPig();
		
		ListElements listElementsNextTo = ArenaUtil.getElementsNextTo(pig, listElements);
		
		Element elementNextTo;
		for (int i=0; i<listElementsNextTo.size(); i++) {
			elementNextTo = listElementsNextTo.get(i);
			
			if (elementNextTo instanceof Enemy && pig.isPowerful()) {
				Power power = pig.getPowerWithEnergy();
				
				if (power instanceof Missile) {
					Missile missile = (Missile) power;
					missile.setPosition(pig.getPosition());
					
					addElement(missile);
					
					MissileAnimation missileAnimation = new MissileAnimation(missile, pig, (Enemy) elementNextTo);
					missileAnimation.start();
				} else {
					PigController.actionPigAttaksEnemy(power, pig, (Enemy) elementNextTo);
				}
			}
		}
	}
	
	public static void startImageAnim(String imageName, Element elementToAct) {
		ImageAnimation imageAnimation = new ImageAnimation(imageName, elementToAct);
		imageAnimation.start();
	}
}
