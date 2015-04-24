package game.element.food;

import game.element.Energy;
import game.element.Pig;
import game.element.Speed;

public class Cake extends Food {

	public static final int VALUE_EVOLVE_PIG_ENERGY = 15;
	
	public Cake() {
		super();
		
		setTitle("Cake");
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
