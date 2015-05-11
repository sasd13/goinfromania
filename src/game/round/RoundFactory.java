package game.round;

import java.awt.Point;

import game.element.character.Pig;

public class RoundFactory {

	public static Round createNewRound(Level level) {
		Round round = new Round();
		
		Pig pig = new Pig();
		round.getListElements().add(pig);
		
		return round;
	}
	
	public static Round createNextRound(Round round, boolean nextLevel, boolean resetPigPosition) {
		Round nextRound = new Round();
		
		Level level = round.getLevel();
		
		if (nextLevel) {
			switch (level) {
				case EASY :
					nextRound.setLevel(Level.NORMAL);
					break;
				case NORMAL : case HARD :
					nextRound.setLevel(Level.HARD);
					break;
				default :
					//TODO Throw exception
					break;
			}
		}
		
		nextRound.setRoundNumber(round.getRoundNumber() + 1);
		nextRound.setScore(round.getScore());
		
		Pig pig = round.getListElements().getPig();
		nextRound.getListElements().add(pig);
		
		if (resetPigPosition) {
			pig.setPosition(new Point());
		}
		
		return nextRound;
	}
}
