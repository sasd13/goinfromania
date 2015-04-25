package game.element.character;

import game.draw.NutritionistDrawing;
import game.element.power.Diet;
import game.element.power.MapPower;

public class Nutritionist extends Character {

	public static final String NAME = "Nutritionist";
	
	public Nutritionist() {
		super();
		
		setTitle(NAME);
		setDrawing(new NutritionistDrawing());
		
		setPowerful(true);
		MapPower mapPower = new MapPower();
		mapPower.put(new Diet());
		
		setMapPower(mapPower);
	}
	
	@Override
	public void attak(Character character) {
		if (isPowerful()) {
			Pig pig = (Pig) character;
			
			Diet diet = (Diet) getMapPower().get(Diet.NAME);
			diet.act(pig);
		}
	}
}
