package util;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.power.Power;

public class EnemyActions {

	public static void enemyAttaksPig(Enemy enemy, Pig pig) {
		Power power = enemy.getPower();
		power.act(pig);
	}
}
