package util;

import java.util.Timer;
import java.util.TimerTask;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Power;

public class EnemyActions {

	private static Timer timer = new Timer();
	public static final int DELAY_BEFORE_ATTAK_AGAIN = 2000;
	
	public static void enemyAttaksPig(Enemy enemy, Pig pig) {
		if (enemy.isPowerful()) {
			timer = new Timer();
			
			Power power = enemy.getPower();
			power.act(pig);
			
			enemy.setPowerful(false);
			startDelay(enemy);
		}
	}
	
	private static synchronized void startDelay(final Enemy enemy) {
		timer.cancel();
		timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				enemy.setPowerful(true);
			}
		};
		
		timer.schedule(task, DELAY_BEFORE_ATTAK_AGAIN);
	}
}
