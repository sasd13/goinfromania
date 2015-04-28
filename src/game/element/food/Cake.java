package game.element.food;

import game.element.character.Pig;
import game.element.draw.CakeDrawing;

public class Cake extends Food {

	public static final String NAME = "Cake";
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 20;
	
	public Cake() {
		super();
		
		setName(NAME);
		setDrawing(new CakeDrawing());
		setMovable(true);
		setSpeed(SPEED_LOW);
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
	}
	
	@Override
	public void act(Pig pig) {
		pig.setEnergy(pig.getEnergy() + getEffectValue());
	}
}
