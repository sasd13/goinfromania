package controller;

import anim.power.DietAnimation;
import anim.power.DiseaseAnimation;
import anim.power.PowerlessAnimation;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.power.Diet;
import game.element.power.Disease;
import game.element.power.Power;

public class EnemyController {
	
	private static final int DELAY_BEFORE_ENEMY_ATTAK_AGAIN = 2000;

	public static void actionEnemyAttaksPig(Power power, Enemy enemy, Pig pig) {
		power.setUsed(true);
		
		if (enemy instanceof Nutritionist) {
			actionDiet((Diet) power, (Nutritionist) enemy, pig);
		} else if (enemy instanceof Virus) {
			actionDisease((Disease) power, (Virus) enemy, pig);
		}
		
		makePowerlessForDuration(enemy);
		
		RoundController.checkPigLife();
	}
	
	private static void actionDiet(Diet diet, Nutritionist nutritionist, Pig pig) {		
		DietAnimation dietAnimation = new DietAnimation(diet, nutritionist, pig);
		dietAnimation.start();
	}
	
	private static void actionDisease(Disease disease, Virus virus, Pig pig) {		
		DiseaseAnimation diseaseAnimation = new DiseaseAnimation(disease, virus, pig);
		diseaseAnimation.start();
	}
	
	private static void makePowerlessForDuration(Enemy enemy) {
		PowerlessAnimation powerlessAnimation = new PowerlessAnimation(enemy);
		powerlessAnimation.setDelay(DELAY_BEFORE_ENEMY_ATTAK_AGAIN);
		powerlessAnimation.start();
	}
}
