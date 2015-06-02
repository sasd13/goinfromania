package controller;

import java.awt.Point;

import controller.anim.AnimationHandler;
import controller.anim.arena.AutoAppearanceAnimation;
import controller.anim.arena.EnemyAutoMoveAnimation;
import controller.anim.arena.FoodAutoMoveAnimation;
import controller.anim.element.MissileAnimation;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.food.Food;
import game.element.food.RaisinCake;
import game.element.power.Missile;
import game.element.power.Power;
import game.round.Level;
import util.ArenaUtil;
import view.round.ArenaView;

public class ArenaController {

	private static ArenaView arenaView;
	private static ListElements listElements;
	
	private static AutoAppearanceAnimation autoAppearanceAnimation;
	private static FoodAutoMoveAnimation foodAutoMoveAnimation;
	private static EnemyAutoMoveAnimation enemyAutoMoveAnimation;
	
	public static void initialize(ArenaView myArenaView, ListElements myListElements, Level level, int roundNumber) {
		arenaView = myArenaView;
		listElements = myListElements;
		
		initializeElements();
		
		autoAppearanceAnimation = new AutoAppearanceAnimation(level, listElements);
		foodAutoMoveAnimation = new FoodAutoMoveAnimation(level, listElements);
		enemyAutoMoveAnimation = new EnemyAutoMoveAnimation(level, listElements);
		
		//Delay avant premiere apparition
		autoAppearanceAnimation.setInitialDelay(5000);
		
		//Decremente les "delay" tous les deux tours
		//Augmente progressivement la difficulte
		int decreaseValue = roundNumber/2 - (roundNumber - 1)%2;
		autoAppearanceAnimation.setDelay(autoAppearanceAnimation.getDelay() - decreaseValue*100);
		foodAutoMoveAnimation.setDelay(foodAutoMoveAnimation.getDelay() - decreaseValue);
		enemyAutoMoveAnimation.setDelay(enemyAutoMoveAnimation.getDelay() - decreaseValue);
		
		//Planifie les animations pour etre lance ulterieurement
		AnimationHandler.prepare(autoAppearanceAnimation);
		AnimationHandler.prepare(foodAutoMoveAnimation);
		AnimationHandler.prepare(enemyAutoMoveAnimation);
	}
	
	private static void initializeElements() {
		if (listElements.isEmpty()) {
			Pig pig = new Pig();
			addElement(pig);
		}
		
		RaisinCake raisinCake = new RaisinCake();
		raisinCake.setPosition(new Point(Element.POSITION_X_MAX / 2, 0));
		addElement(raisinCake);
		
		Nutritionist nutritionist = new Nutritionist();
		nutritionist.setPosition(new Point(Element.POSITION_X_MAX - nutritionist.getDimension().width, Element.POSITION_Y_MAX - nutritionist.getDimension().height));
		addElement(nutritionist);
	}
	
	public static void start() {
		arenaView.requestFocusInWindow();
		
		listElements.getPig().setMovable(true);
		
		AnimationHandler.startAll();
	}
	
	public static void pause() {
		listElements.getPig().setMovable(false);
		
		AnimationHandler.stopAll();
	}
	
	public static void stop() {
		listElements.getPig().setMovable(false);
		
		AnimationHandler.finishAll();
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
		if (elementInTouch instanceof Food) {
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
					AnimationHandler.start(missileAnimation);
				} else {
					PigController.actionPigAttaksEnemy(power, pig, (Enemy) elementNextTo);
				}
			}
		}
	}
}
