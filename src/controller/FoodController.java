package controller;

import game.element.character.Pig;
import game.element.food.Cake;
import game.element.food.Food;
import game.element.food.PoisonCake;
import game.element.food.StrawberryCake;

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
