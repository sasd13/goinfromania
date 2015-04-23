package game.element.edible;

import game.element.Character;
import game.element.Energy;
import game.element.Pig;

public class CakeEffect extends Effect {

	public static final int VALUE_INCREASE_PIG_ENERGY = 20;
	
	public CakeEffect() {
		super();
		
		setTitle("Cake Effect");
		setValue(VALUE_INCREASE_PIG_ENERGY);
	}
	
	@Override
	public void act(Character character) {
		Pig pig = (Pig) character;
		
		Energy energy = pig.getEnergy();
		energy.setValue(energy.getValue() + getValue());
	}
}
