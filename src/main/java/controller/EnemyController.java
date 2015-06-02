package main.java.controller;

import main.java.controller.anim.AnimationHandler;
import main.java.controller.anim.element.DietAnimation;
import main.java.controller.anim.element.DiseaseAnimation;
import main.java.controller.anim.element.PowerlessAnimation;
import main.java.game.element.character.Enemy;
import main.java.game.element.character.Nutritionist;
import main.java.game.element.character.Pig;
import main.java.game.element.character.Virus;
import main.java.game.element.power.Diet;
import main.java.game.element.power.Disease;
import main.java.game.element.power.Power;

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
