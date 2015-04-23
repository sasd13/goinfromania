package game.element.edible;

import game.element.Energy;
import game.element.Pig;
import game.element.Speed;

public class Cake extends Food {

	public Cake() {
		super();
		
		setTitle("Cake");
		setMovable(true);
		getSpeed().setValue(Speed.SPEED_LOW);
	}
	
	@Override
	public void act(Pig pig) {
		Energy energy = pig.getEnergy();
		energy.setValue(energy.getValue() + getEffect().getValue());
	}
}
