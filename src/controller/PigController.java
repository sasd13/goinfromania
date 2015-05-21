package controller;

import game.anim.power.BoomAnimation;
import game.anim.power.HitAnimation;
import game.anim.power.ParalyzeAnimation;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Missile;
import game.element.power.Paralyze;
import game.element.power.Power;

public class PigController {
	
	public static final String ANIMATION_HIT_IMAGE_PREFIX = "hit_";
	
	public static void actionPigAttaksEnemy(Power power, Pig pig, Enemy enemy) {
		power.setUsed(true);
		
		if (power instanceof Paralyze) {
			actionParalyze((Paralyze) power, pig, enemy);
		} else if (power instanceof Missile) {
			actionMissile((Missile) power, pig, enemy);
		}
	}
	
	private static void actionParalyze(Paralyze paralyze, Pig pig, Enemy enemy) {
		ParalyzeAnimation paralyzeAnimation = new ParalyzeAnimation(paralyze, pig, enemy);
		paralyzeAnimation.start();
	}
	
	private static void actionMissile(Missile missile, Pig pig, Enemy enemy) {
		enemy.setLife(enemy.getLife() - missile.getPowerValue());
		
		if (!enemy.isDied()) {
			startHitAnimation(enemy);
			
			ArenaController.removeElement(missile);
		} else {
			missile.setMovable(false);
			
			startBoomAnimation(missile, pig, enemy);
			
			ArenaController.removeElement(enemy);
			RoundController.cumuleEnemyStatistics(enemy);
		}
	}
	
	private static void startHitAnimation(Enemy enemy) {
		HitAnimation hitAnimation = new HitAnimation(enemy);
		hitAnimation.start();
	}
	
	private static void startBoomAnimation(Missile missile, Pig pig, Enemy enemy) {
		BoomAnimation boomAnimation = new BoomAnimation(missile);
		boomAnimation.start();
	}
}
