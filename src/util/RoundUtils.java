package util;

import game.element.Element;
import game.element.character.Enemy;
import game.element.character.Pig;
import game.element.food.Food;
import game.round.Level;
import game.round.Round;

public class RoundUtils {

	public static boolean isRoundOver(Round round) {
		Pig pig = round.getListElements().getPig();
		
		if (pig.isDied()) {
			round.setFinished(true);
			
			return true;
		}
		
		return false;
	}
	
	public static boolean isRoundWon(Round round) {
		Level level = round.getLevel();
		
		int countEatenCake = round.getCountEatenCakes();
		
		if ((level == Level.EASY && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_EASY)
				|| (level == Level.NORMAL && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_NORMAL)
				|| (level == Level.HARD && countEatenCake == Round.TOTAL_CAKE_TO_EAT_LEVEL_HARD)) {
			round.setFinished(true);
			
			return true;
		}
		
		return false;
	}
	
	public static void removeElement(Round round, Element element) {
		round.getListElements().remove(element);
	}
	
	public static void removeElementAndCumulScore(Round round, Element element) {
		boolean ended = false;
		int scoreValue = 0;
		
		if (element instanceof Food) {
			Food food = (Food) element;
			if (food.isEated()) {
				ended = true;
				scoreValue = food.getScorePoint();
			}
		} else if (element instanceof Enemy) {
			Enemy enemy = (Enemy) element;
			if (enemy.isDied()) {
				ended = true;
				scoreValue = enemy.getScorePoint();
			}
		}
		
		if (ended) {
			round.getListElements().remove(element);
			round.setScore(round.getScore() + scoreValue);
			
			isRoundWon(round);
		}
	}
}
