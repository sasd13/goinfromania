package game.element.character;

import game.element.draw.NutritionistDrawing;
import game.element.power.Diet;
import game.element.power.MapPower;
import game.round.Score;

public class Nutritionist extends Character {

	public static final String NAME = "Nutritionist";
	public static final int SCORE_VALUE = 500;
	
	public Nutritionist() {
		super();
		
		setName(NAME);
		setDrawing(new NutritionistDrawing());
		setScore(new Score(SCORE_VALUE));
		setPowerful(true);
		
		MapPower mapPower = new MapPower();
		mapPower.put(new Diet());
		setMapPower(mapPower);
	}
	
	@Override
	public Score attak(Character character) {
		if (isPowerful()) {
			Pig pig = (Pig) character;
			
			Diet diet = (Diet) getMapPower().get(Diet.NAME);
			diet.act(pig);
		}
		
		return null;
	}
}
