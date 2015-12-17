package main.java.controller;

import main.java.controller.anim.AnimationHandler;
import main.java.controller.anim.element.BoomAnimation;
import main.java.controller.anim.element.HitAnimation;
import main.java.controller.anim.element.ParalyzeAnimation;
import main.java.game.element.character.Enemy;
import main.java.game.element.character.Pig;
import main.java.game.element.power.Missile;
import main.java.game.element.power.Paralyze;
import main.java.game.element.power.Power;

public class PigController {
	
	public static void actionPigAttaksEnemy(Power power, Pig pig, Enemy enemy) {
		if (power instanceof Paralyze) {
			actionParalyze((Paralyze) power, pig, enemy);
		} else if (power instanceof Missile) {
			actionMissile((Missile) power, pig, enemy);
		}
	}
	
	private static void actionParalyze(Paralyze paralyze, Pig pig, Enemy enemy) {		
		ParalyzeAnimation paralyzeAnimation = new ParalyzeAnimation(paralyze, pig, enemy);
		AnimationHandler.start(paralyzeAnimation);
	}
	
	private static void actionMissile(Missile missile, Pig pig, Enemy enemy) {
		enemy.setLife(enemy.getLife() - missile.getPowerValue());
		
		if (!enemy.isDied()) {
			startHitAnimation(enemy);
			
			ArenaController.removeElement(missile);
		} else {
			startBoomAnimation(missile);
			
			ArenaController.removeElement(enemy);
			RoundController.cumuleEnemyStatistics(enemy);
		}
	}
	
	private static void startHitAnimation(Enemy enemy) {
		HitAnimation hitAnimation = new HitAnimation(enemy);
		AnimationHandler.start(hitAnimation);
	}
	
	private static void startBoomAnimation(Missile missile) {
		BoomAnimation boomAnimation = new BoomAnimation(missile);
		AnimationHandler.start(boomAnimation);
	}
}
