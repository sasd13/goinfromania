package game.element.food;

import game.draw.CakeDrawing;
import game.element.Speed;
import game.element.character.Energy;
import game.element.character.Pig;

public class Cake extends Food {

	public static final String NAME = "Cake";
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 15;
	
	public Cake() {
		super();
		
		setTitle(NAME);
		setDrawing(new CakeDrawing());
		setMovable(true);
		setSpeed(new Speed(Speed.SPEED_LOW));
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
	}
	
	@Override
	public void act(Pig pig) {
		Energy energy = pig.getEnergy();
		energy.setValue(energy.getValue() + getEffectValue());
	}
}
