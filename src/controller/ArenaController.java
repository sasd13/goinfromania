package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import game.element.Direction;
import game.element.Element;
import game.element.ListElements;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.food.Food;
import game.element.power.Missile;
import game.element.power.Power;
import game.round.Round;
import util.ArenaUtil;
import util.animation.AppearanceAnimation;
import util.animation.BoomAnimation;
import util.animation.MissileNextAnimation;
import util.animation.MoveAnimation;
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
	
	public static void actionEnemyAttaksPig(Enemy enemy, Power power) {		
		Pig pig = listElements.getPig();
		
		power.act(enemy, pig);
		power.setUsed(true);
		enemy.setPowerlessForDelay();
		
		RoundController.checkPigLife();
	}
	
	public static void actionPigEatsFood(Food food) {
		Pig pig = listElements.getPig();
		
		food.act(pig);
		
		food.setEated(true);
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
				Power power = pig.getPowerWithEnergy();
				
				if (power instanceof Missile) {
					Point position = ArenaUtil.getPositionNextTo(pig, elementNextTo);
					
					Missile missile = (Missile) power;
					missile.setPosition(position);
					
					listElements.add(missile);
					MissileNextAnimation missileNextAnimation = new MissileNextAnimation(missile, (Enemy) elementNextTo);
					missileNextAnimation.start();
				} else {
					actionPigAttaksEnemy((Enemy) elementNextTo, power);
				}
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
	
	public static void actionPigAttaksEnemy(Enemy enemy, final Power power) {
		Pig pig = listElements.getPig();
		
		power.act(pig, enemy);
		
		power.setUsed(true);
		
		if (enemy.isDied()) {
			if (power instanceof Missile) {
				Missile missile = (Missile) power;
				BoomAnimation boomAnimation = new BoomAnimation(enemy, missile, missile.ANIMATION_BOOM_IMAGE_PREFIX + missile.getImageName(), listElements);
				boomAnimation.start();
			}
			RoundController.cumuleEnemyStatistics(enemy);
		}
	}
}
