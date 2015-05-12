package game.util;

import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.food.Food;
import game.element.power.Power;

public class PigAction {

	public static void pigEatsFood(Pig pig, Food food) {
		if (pig.isGreedy()) {
			food.setEated(true);
			food.act(pig);
		}
	}
	
	public static void pigAttaksEnemy(Pig pig, Enemy enemy, Power power) {
		if (pig.isPowerful()) {
			power.act(enemy);
		}
	}
}
