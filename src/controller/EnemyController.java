package controller;

import game.anim.power.DietAnimation;
import game.anim.power.DiseaseAnimation;
import game.element.character.Enemy;
import game.element.character.Nutritionist;
import game.element.character.Pig;
import game.element.character.Virus;
import game.element.power.Diet;
import game.element.power.Disease;
import game.element.power.Power;

public class EnemyController {

	public static void actionEnemyAttaksPig(Power power, Enemy enemy, Pig pig) {
		power.setUsed(true);
		
		if (enemy instanceof Nutritionist) {
			actionDiet((Diet) power, (Nutritionist) enemy, pig);
		} else if (enemy instanceof Virus) {
			actionDisease((Disease) power, (Virus) enemy, pig);
		}
		
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
}
