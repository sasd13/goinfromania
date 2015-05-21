package controller;

import game.anim.AppearanceAnimation;
import game.anim.ImageAnimation;
import game.anim.MoveAnimation;
import game.anim.power.MissileAnimation;
import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.food.Food;
import game.element.power.Missile;
import game.element.power.Power;
import game.round.Round;
import game.util.ArenaUtil;
import view.round.ArenaView;

public class ArenaController {

	private static ArenaView arenaView;
	private static ListElements listElements;
	
	private static AppearanceAnimation appearanceAnimation;
	private static MoveAnimation moveAnimation;
	
	public static void initialize(ArenaView myArenaView, Round round) {
		arenaView = myArenaView;
		listElements = round.getListElements();
		
		appearanceAnimation = new AppearanceAnimation(listElements, round.getLevel());
		moveAnimation = new MoveAnimation(listElements);
	}
	
	public static void start() {		
		arenaView.requestFocusInWindow();
		
		appearanceAnimation.start();
		moveAnimation.start();
	}
	
	public static void stop() {
		appearanceAnimation.stop();
		moveAnimation.stop();
	}
	
	public static void repaintArena() {
		arenaView.repaint();
	}
	
	public static void addElement(Element element) {
		listElements.add(element);
	}
	
	public static void removeElement(Element element) {
		listElements.remove(element);
	}
	
	public static void actionMove(Element elementActor, Direction direction) {
		boolean canMove = ArenaUtil.canMoveInDirection(elementActor, direction, listElements);
		if (canMove) {
			elementActor.move(direction);
			repaintArena();
			
			checkElementsInTouch(elementActor, listElements);
		}
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
				Pig pig = (Pig) elementActor;
				
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
			} else if (elementActor instanceof Enemy && elementInTouch instanceof Pig) {
				Enemy enemy = (Enemy) elementActor;
				
				if (enemy.isPowerful()) {
					EnemyController.actionEnemyAttaksPig(enemy.getPower(), enemy, (Pig) elementInTouch);
				}
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
					
					listElements.add(missile);
					
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
