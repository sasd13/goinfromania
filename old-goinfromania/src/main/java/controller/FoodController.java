package main.java.controller;

import main.java.game.element.character.Pig;
import main.java.game.element.food.Cake;
import main.java.game.element.food.Food;
import main.java.game.element.food.PoisonCake;
import main.java.game.element.food.StrawberryCake;

public class FoodController {

	public static void actionPigEatsFood(Food food, Pig pig) {
		food.setEated(true);
		
		if (food instanceof Cake) {
			actionPigEatsCake((Cake) food, pig);
		} else if (food instanceof PoisonCake) {
			actionPigEatsPoisonCake((PoisonCake) food, pig);
		}
		
		ArenaController.removeElement(food);
		RoundController.cumuleFoodStatistics(food);
		RoundController.checkEatenCakes();
	}
	
	private static void actionPigEatsCake(Cake cake, Pig pig) {
		if (cake instanceof StrawberryCake) {
			pig.setLife(pig.getLife() + cake.getEffectValue());
		} else {
			pig.setEnergy(pig.getEnergy() + cake.getEffectValue());
		}
	}
	
	private static void actionPigEatsPoisonCake(PoisonCake poisonCake, Pig pig) {
		pig.setEnergy(pig.getEnergy() - poisonCake.getEffectValue());
	}
}
