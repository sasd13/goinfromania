package controller;

import controller.anim.AnimationHandler;
import controller.anim.element.DietAnimation;
import controller.anim.element.DiseaseAnimation;
import controller.anim.element.PowerlessAnimation;
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
		AnimationHandler.start(dietAnimation);
	}
	
	private static void actionDisease(Disease disease, Virus virus, Pig pig) {		
		DiseaseAnimation diseaseAnimation = new DiseaseAnimation(disease, virus, pig);
		AnimationHandler.start(diseaseAnimation);
	}
	
	private static void makePowerlessForDuration(Enemy enemy) {
		PowerlessAnimation powerlessAnimation = new PowerlessAnimation(enemy);
		powerlessAnimation.setDelay(DELAY_BEFORE_ENEMY_ATTAK_AGAIN);
		AnimationHandler.start(powerlessAnimation);
	}
}
