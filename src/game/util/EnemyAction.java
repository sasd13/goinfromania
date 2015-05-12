package game.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Power;

public class EnemyAction {

	public static final int DELAY_BEFORE_ATTAK_AGAIN = 2000;
	
	public void enemyAttaksPig(Enemy enemy, Pig pig) {
		if (enemy.isPowerful()) {
			Power power = enemy.getPower();
			power.act(pig);
			
			enemy.setPowerful(false);
			startDelay(enemy);
		}
	}
	
	private synchronized void startDelay(final Enemy enemy) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				enemy.setPowerful(true);
			}
		};
		
		scheduler.schedule(runnable, DELAY_BEFORE_ATTAK_AGAIN, TimeUnit.MILLISECONDS);
	}
}
